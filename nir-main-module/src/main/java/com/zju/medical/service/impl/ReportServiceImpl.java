package com.zju.medical.service.impl;


import com.zju.medical.common.pojo.ReportMessage;
import com.zju.medical.common.pojo.bo.ReportDataBO;
import com.zju.medical.common.pojo.xdo.*;
import com.zju.medical.common.result.ReturnResult;
import com.zju.medical.common.utils.FileUtils;
import com.zju.medical.common.xenum.AdhdTaskTypeEnum;
import com.zju.medical.dao.mapper.ReportMapper;
import com.zju.medical.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import static com.zju.medical.common.constant.ReportConstant.STATIC_RESOURCE_DIR;

/**
 * @author xiaoguo
 */

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private UserService userService;

    @Autowired
    private BloodOxygenDataPathService dataPathService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private PdfReportService pdfReportService;

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public ReportMessage createUserReportById(Integer userId) {

        /**
         * 根据id查询数据库中用户的相关信息生成{@link com.zju.medical.nir.common.pojo.bo.ReportDataBO}对象
         */
        ReportDataBO reportData = this.createReportData(userId);

        /**
         * 调用 pdfReportService 生成报告
         */
        String pdfAbsPath = pdfReportService.createPdf(reportData);

        if (pdfAbsPath == null || pdfAbsPath.isEmpty()) {
            ReportMessage reportMessage = new ReportMessage();
            reportMessage.setCreated(false);
            return reportMessage;
        }

        /**
         * 插入或者更新report 路径到数据库
         */
        ReturnResult<Integer> result = this.upsertReport(pdfAbsPath, userId);

        String relativePath = getPathRelativeToClassPath(pdfAbsPath);
        /**
         * 封装ReportMessage信息返回
         */
        ReportMessage reportMessage = new ReportMessage();
        if (StringUtils.isEmpty(relativePath)) {
            reportMessage.setCreated(false);
            return reportMessage;
        }
        reportMessage.setAbsPath(pdfAbsPath);
        reportMessage.setRelativePath(relativePath);
        reportMessage.setCreated(true);

        return reportMessage;
    }

    private ReturnResult<Integer> upsertReport(String pdfAbsPath, Integer userId) {
        Date date = new Date();
        ReportDO reportDO = reportMapper.selectByPrimaryKey(userId);

        try {
            if (reportDO != null) {
                // 更新
                reportDO.setReportPath(pdfAbsPath);
                reportDO.setUpdateTime(date);
                reportMapper.updateByPrimaryKey(reportDO);
                return ReturnResult.SUCCEED;
            } else {
                // 插入
                reportDO = new ReportDO();

                reportDO.setCreateTime(date);
                reportDO.setReportPath(pdfAbsPath);
                reportDO.setUpdateTime(date);
                reportDO.setUserId(userId);
                int insert = reportMapper.insert(reportDO);
                if (insert == -1) {
                    return ReturnResult.FAILED;
                } else {
                    return ReturnResult.SUCCEED;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnResult.FAILED;
        }

    }


    // 根据id，找到用户报告中所需要的数据
    private ReportDataBO createReportData(int userId) {

        ReportDataBO reportData = new ReportDataBO();
        UserDO user = userService.selectUserById(userId);
        reportData.setUserId(user.getId());
        reportData.setUserAge(user.getAge());


        Map<AdhdTaskTypeEnum, ReportDataBO.ScoreInfoForTask> taskAndScore = new TreeMap<>();

        ReturnResult<ReyTaskDO> reyTask = taskService.selectReyTaskById(userId);


        ReyTaskDO reyTaskData = reyTask.getData();
        if (null != reyTaskData) {
            ReportDataBO.ScoreInfoForTask scoreInfo = new ReportDataBO.ScoreInfoForTask();
            scoreInfo.setTaskDate(reyTaskData.getCreateTime());
            scoreInfo.addScore("图形即时结构得分", reyTaskData.getReySiScore());
            scoreInfo.addScore("图形即时细节得分", reyTaskData.getReyDiScore());
            scoreInfo.addScore("图形延迟结构得分", reyTaskData.getReySdScore());
            scoreInfo.addScore("图形延迟细节得分 ", reyTaskData.getReyDdScore());
            taskAndScore.put(AdhdTaskTypeEnum.REY_COMPLEX_FIGURE_MEMORY_TASK, scoreInfo);
        }

        WordTaskDO wordTaskData = taskService.selectWordTaskById(userId).getData();
        if (null != wordTaskData) {
            ReportDataBO.ScoreInfoForTask scoreInfo = new ReportDataBO.ScoreInfoForTask();
            scoreInfo.setTaskDate(wordTaskData.getCreateTime());
            scoreInfo.addScore("A式完成时间", wordTaskData.getaWordTime());
            scoreInfo.addScore("A式错误数", wordTaskData.getaWordMis());
            scoreInfo.addScore("B式完成时间", wordTaskData.getbWordMis());
            scoreInfo.addScore("B式错误数", wordTaskData.getbWordMis());
            taskAndScore.put(AdhdTaskTypeEnum.DIGIT_ALPHABET_LINKING_TASK, scoreInfo);
        }

        StroopTaskDO stroopTaskData = taskService.selectStroopTaskById(userId).getData();
        if (null != stroopTaskData) {
            ReportDataBO.ScoreInfoForTask scoreInfo = new ReportDataBO.ScoreInfoForTask();
            scoreInfo.setTaskDate(stroopTaskData.getCreateTime());
            scoreInfo.addScore("A读汉字完成时间", stroopTaskData.getaStroopTime());
            scoreInfo.addScore("A读汉字错误数 ", stroopTaskData.getaStroopMis());
            scoreInfo.addScore("B读颜色完成时间", stroopTaskData.getbStroopTime());
            scoreInfo.addScore("B读颜色错误数 ", stroopTaskData.getbStroopMis());
            scoreInfo.addScore("C色字名字完成时间", stroopTaskData.getcStroopTime());
            scoreInfo.addScore("C色字名字错误数 ", stroopTaskData.getcStroopMis());
            scoreInfo.addScore("D色字命色完成时间", stroopTaskData.getdStroopTime());
            scoreInfo.addScore("D色字命色错误数 ", stroopTaskData.getdStroopMis());
            taskAndScore.put(AdhdTaskTypeEnum.STROOP_COLOR_WORDS_TASK, scoreInfo);
        }


        SnapTaskDO snapTaskData = taskService.selectSnapTaskById(userId).getData();
        if (null != snapTaskData) {
            ReportDataBO.ScoreInfoForTask scoreInfo = new ReportDataBO.ScoreInfoForTask();
            scoreInfo.setTaskDate(snapTaskData.getCreateTime());
            scoreInfo.addScore("家长评分", snapTaskData.getSnapParentScore());
            scoreInfo.addScore("老师评分", snapTaskData.getSnapTeacherScore());
            taskAndScore.put(AdhdTaskTypeEnum.SNAP_TASK, scoreInfo);
        }


        reportData.setTaskScoreInfo(taskAndScore);

        Map<AdhdTaskTypeEnum, ReportDataBO.BloodOxygenInfoForTask> taskAndBloodOxygen = new TreeMap<>();

        BloodOxygenDO bloodOxygen = dataPathService.selectDataPath(userId).getData();
        ReportDataBO.BloodOxygenInfoForTask taskBloodOxygen = new ReportDataBO.BloodOxygenInfoForTask();
//        taskBloodOxygen.setDate(bloodOxygen.getCreateTime());
        taskBloodOxygen.setFilePath(bloodOxygen.getDataPath1());
        taskAndBloodOxygen.put(AdhdTaskTypeEnum.REY_COMPLEX_FIGURE_MEMORY_TASK, taskBloodOxygen);

        taskBloodOxygen = new ReportDataBO.BloodOxygenInfoForTask();
        taskBloodOxygen.setFilePath(bloodOxygen.getDataPath2());
        taskAndBloodOxygen.put(AdhdTaskTypeEnum.DIGIT_ALPHABET_LINKING_TASK, taskBloodOxygen);

        taskBloodOxygen = new ReportDataBO.BloodOxygenInfoForTask();
        taskBloodOxygen.setFilePath(bloodOxygen.getDataPath3());
        taskAndBloodOxygen.put(AdhdTaskTypeEnum.STROOP_COLOR_WORDS_TASK, taskBloodOxygen);

        taskBloodOxygen = new ReportDataBO.BloodOxygenInfoForTask();
        taskBloodOxygen.setFilePath(bloodOxygen.getDataPath4());
        taskAndBloodOxygen.put(AdhdTaskTypeEnum.RESTING_STATE_TASK, taskBloodOxygen);

        reportData.setTaskBloodOxygenInfo(taskAndBloodOxygen);
        return reportData;
    }


    private String getPathRelativeToClassPath(String pdfAbsPath) {

        if (StringUtils.isEmpty(pdfAbsPath) || pdfAbsPath.length() <= STATIC_RESOURCE_DIR.length()) {
            return null;
        }

        FileUtils.createDirectory(new File(STATIC_RESOURCE_DIR));

        String temp = pdfAbsPath.substring(STATIC_RESOURCE_DIR.length());
        if (temp.startsWith("/") || temp.startsWith("\\")) {
            return temp.substring(1);
        }
        return temp;
    }
}
