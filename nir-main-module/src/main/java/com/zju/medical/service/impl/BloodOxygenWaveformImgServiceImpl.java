package com.zju.medical.service.impl;


import com.zju.medical.common.constant.ReportConstant;
import com.zju.medical.common.pojo.bo.ReportDataBO;
import com.zju.medical.common.utils.FileUtils;
import com.zju.medical.common.xenum.AdhdTaskTypeEnum;
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
            String imgFileNamePrefix) {


        File imgStorageDir = new File(ReportConstant.CLASSPATH, ReportConstant.IMG_FILE_SAVE_PATH);
        FileUtils.createDirectory(imgStorageDir);

        Map<AdhdTaskTypeEnum, List<String>> result = new TreeMap<>();
        for (Map.Entry<AdhdTaskTypeEnum, ReportDataBO.BloodOxygenInfoForTask> entry : taskBloodOxygenInfo.entrySet()) {
            AdhdTaskTypeEnum taskType = entry.getKey();
            ReportDataBO.BloodOxygenInfoForTask taskData = entry.getValue();
            String dataFilePath = taskData.getFilePath();

            try {
                String pyFilePath = new File(ReportConstant.CLASSPATH, ReportConstant.PY_SCRIPT_PATH).getAbsolutePath();
                String[] params = {"python",
                        pyFilePath,
                        dataFilePath,
                        imgStorageDir.getAbsolutePath(),
                        imgFileNamePrefix
                };

                InputStream inputStream = Runtime.getRuntime().exec(params).getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

                String rcv = br.readLine();
                if (StringUtils.isEmpty(rcv)) {
                    logger.error("调用python画波形图失败，返回paths结果为空");
                    continue;
                }
                String[] paths = rcv.split(";");
//                LinkedList<String> paths = new LinkedList<>();
//                for (int i = 0; i < ReportConstant.IMG_NUM; i++) {
//                    try {
//                        String imgPath = br.readLine();
//                        if (StringUtils.isEmpty(imgPath)) {
//                            continue;
//                        }
//                        if (imgPath.equals(ReportConstant.NO_IMG)) continue;
////                        result.get(taskType).var;
//
//                        paths.add(imgPath);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                        logger.error("生成task为 \"" + taskType.getTaskChineseName() + "\"的 " + ReportConstant.WAVEFORM_TITLE[i] + " 波形图片文件出错！");
//                        continue;
//                    }
//                }

                result.put(taskType, Arrays.asList(paths));

            } catch (IOException e) {
                logger.error(taskType.getTaskChineseName() +":执行py脚本出错");
            }
        }

        return result;
    }
}
