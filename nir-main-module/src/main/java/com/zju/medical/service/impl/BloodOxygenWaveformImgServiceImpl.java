package com.zju.medical.service.impl;


import com.zju.medical.common.constant.ReportConstant;
import com.zju.medical.common.pojo.ChannelData;
import com.zju.medical.common.pojo.bo.ReportDataBO;
import com.zju.medical.common.utils.BloodOxygenDataFileUtils;
import com.zju.medical.common.utils.FileUtils;
import com.zju.medical.common.utils.ReportImageUtils;
import com.zju.medical.common.xenum.AdhdTaskTypeEnum;
import com.zju.medical.config.ReportImageConfig;
import com.zju.medical.service.BloodOxygenWaveformImgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author xiaoguo
 */

@Service
public class BloodOxygenWaveformImgServiceImpl implements BloodOxygenWaveformImgService {

    private static final Logger logger = LoggerFactory.getLogger(BloodOxygenWaveformImgServiceImpl.class);


    @Override
    public boolean alreadyExists(String imgName) {
        return false;
    }

    @Override
    public boolean deleteExistImg(String imgName) {
        return false;
    }


    @Override
    public Map<AdhdTaskTypeEnum, List<String>> createImgFile(
            Map<AdhdTaskTypeEnum, ReportDataBO.BloodOxygenInfoForTask> taskBloodOxygenInfo,
            String userIdString,
            ReportImageConfig config) {


        File imgStorageDir = new File(ReportConstant.CLASSPATH, ReportConstant.IMG_FILE_SAVE_PATH);
        FileUtils.createDirectory(imgStorageDir);

        Map<AdhdTaskTypeEnum, List<String>> result = new TreeMap<>();
        for (Map.Entry<AdhdTaskTypeEnum, ReportDataBO.BloodOxygenInfoForTask> entry : taskBloodOxygenInfo.entrySet()) {
            // 任务类型： 是哪一个任务
            AdhdTaskTypeEnum taskType = entry.getKey();
            // 任务的血氧信息
            ReportDataBO.BloodOxygenInfoForTask taskData = entry.getValue();

            String dataFilePath = taskData.getFilePath();
            if (StringUtils.isEmpty(dataFilePath)) {
                continue;
            }

            List<String> taskImgPaths = null;
            // 区分用java还是python画图
            if (BloodOxygenWaveformImgService.DRAW_WITH_JAVA.equals(config.getDrawWith())) {
                taskImgPaths = drawWithJava(dataFilePath,
                        imgStorageDir.getAbsolutePath(),
                        userIdString,
                        taskType.getTaskIdentifier());
            } else if (BloodOxygenWaveformImgService.DRAW_WITH_PYTHON.equals(config.getDrawWith())) {
                taskImgPaths = drawWithPython(dataFilePath,
                        imgStorageDir.getAbsolutePath(),
                        userIdString,
                        taskType.getTaskIdentifier(),
                        null);
            }

            if (taskImgPaths != null) {
                result.put(taskType, taskImgPaths);
            }
        }

        return result;
    }

    /**
     * 调用python绘制【一个】任务的图片，返回图片的路径列表
     *
     * @param dataFilePath   数据文件的路径
     * @param imgStorageDir  生成的图片存储的目录（文件夹）
     * @param userId         用户id
     * @param taskIdentifier 任务的标识
     * @param pyFilePath 输入null则系统自动获取，指定了path则以指定的为准
     * @return
     */
    private List<String> drawWithPython(String dataFilePath, String imgStorageDir,
                                        String userId, String taskIdentifier,
                                        String pyFilePath) {

        List<String> ret = null;
        try {
            if (pyFilePath == null) {
                pyFilePath = new File(ReportConstant.CLASSPATH, ReportConstant.PY_SCRIPT_PATH)
                        .getAbsolutePath();
            }
            String[] params = {"python",
                    pyFilePath,
                    dataFilePath,
                    imgStorageDir,
                    // 生成的图片的前缀，用以区分不同的图片
                    userId + "-task" + taskIdentifier + "-"
            };

            InputStream inputStream = Runtime.getRuntime().exec(params).getErrorStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String rcv = br.readLine();
            if (StringUtils.isEmpty(rcv)) {
                logger.error("调用python画波形图失败，返回paths结果为空");
                return null;
            }
            String[] paths = rcv.split(";");
            ret = Arrays.asList(paths);

        } catch (IOException e) {
            logger.error("任务" + taskIdentifier + ":执行py脚本出错");
        }
        return ret;
    }


    /**
     * 用java绘制【一个】任务的图片，返回图片的路径列表
     *
     * @param taskDataFilePath 任务的数据文件的路径
     * @param imgStorageDir    生成的图片存储的目录（文件夹）
     * @param userId           用户id
     * @param taskIdentifier   任务的标识
     * @return 当前任务的多个图片路径  返回null说明所有图片均创建失败
     */
    private List<String> drawWithJava(String taskDataFilePath, String imgStorageDir,
                                      String userId, String taskIdentifier) {


        List<ChannelData> firstValidChannelData
                = BloodOxygenDataFileUtils.getFirstValidChannelData(new File(taskDataFilePath));

        if (firstValidChannelData == null) {
            logger.error("用户id为{}的第{}个任务的血氧数据文件无有效通道数据", userId, taskIdentifier);
            return null;
        }
        List<String> ret = ReportImageUtils.drawChannelWaveformAndSave(
                firstValidChannelData,
                imgStorageDir,
                userId + "-task" + taskIdentifier + "-");

        return ret;

    }
}
