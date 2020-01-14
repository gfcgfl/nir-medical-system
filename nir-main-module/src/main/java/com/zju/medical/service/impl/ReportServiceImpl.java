package com.zju.medical.service.impl;


import com.zju.medical.common.pojo.ReportMessage;
import com.zju.medical.common.pojo.bo.ReportDataBO;
import com.zju.medical.common.pojo.xdo.*;
import com.zju.medical.common.result.ReturnResult;
import com.zju.medical.common.utils.FileUtils;
import com.zju.medical.common.xenum.AdhdTaskTypeEnum;
import com.zju.medical.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
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
    private DataPathService dataPathService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private PdfReportService pdfReportService;



    @Override
    public ReportMessage createUserReportById(Integer userId) {

        /**
         * 根据id查询数据库中用户的相关信息生成{@link com.zju.medical.nir.common.pojo.bo.ReportDataBO}对象
         */
        ReportDataBO reportData = new ReportDataBO();
        UserDO user = userService.selectUserById(userId);
        reportData.setUserId(user.getId());
        reportData.setUserAge(user.getAge());


        Map<AdhdTaskTypeEnum, ReportDataBO.ScoreInfoForTask> taskAndScore = new TreeMap<>();

        ReturnResult<ReyTaskDO> reyTask = taskService.selectReyTaskById(userId);
        ReyTaskDO reyTaskData = reyTask.getData();
        ReportDataBO.ScoreInfoForTask scoreInfo = new ReportDataBO.ScoreInfoForTask();
        scoreInfo.setTaskDate(reyTaskData.getCreateTime());
        scoreInfo.addScore("复杂图形即时结构", reyTaskData.getReySiScore());
        scoreInfo.addScore("复杂图形即时细节", reyTaskData.getReyDiScore());
        scoreInfo.addScore("复杂图形延迟结构", reyTaskData.getReySdScore());
        scoreInfo.addScore("复杂图形延迟细节 ", reyTaskData.getReyDdScore());
        taskAndScore.put(AdhdTaskTypeEnum.REY_COMPLEX_FIGURE_MEMORY_TASK, scoreInfo);

        WordTaskDO wordTaskData = taskService.selectWordTaskById(userId).getData();
        scoreInfo = new ReportDataBO.ScoreInfoForTask();
        scoreInfo.setTaskDate(wordTaskData.getCreateTime());
        scoreInfo.addScore("A式完成时间", wordTaskData.getaWordTime());
        scoreInfo.addScore("A式错误数", wordTaskData.getaWordMis());
        scoreInfo.addScore("B式完成时间", wordTaskData.getbWordMis());
        scoreInfo.addScore("B式错误数", wordTaskData.getbWordMis());
        taskAndScore.put(AdhdTaskTypeEnum.DIGIT_ALPHABET_LINKING_TASK, scoreInfo);

        StroopTaskDO stroopTaskData = taskService.selectStroopTaskById(userId).getData();
        scoreInfo = new ReportDataBO.ScoreInfoForTask();
        scoreInfo.setTaskDate(stroopTaskData.getCreateTime());
        scoreInfo.addScore("1部分完成时间", stroopTaskData.getaStroopTime());
        scoreInfo.addScore("1部分错误数 ", stroopTaskData.getaStroopMis());
        scoreInfo.addScore("2部分完成时间", stroopTaskData.getbStroopTime());
        scoreInfo.addScore("2部分错误数 ", stroopTaskData.getbStroopMis());
        scoreInfo.addScore("3部分完成时间", stroopTaskData.getcStroopTime());
        scoreInfo.addScore("3部分错误数 ", stroopTaskData.getcStroopMis());
        scoreInfo.addScore("4部分完成时间", stroopTaskData.getdStroopTime());
        scoreInfo.addScore("4部分错误数 ", stroopTaskData.getdStroopMis());
        taskAndScore.put(AdhdTaskTypeEnum.STROOP_COLOR_WORDS_TASK, scoreInfo);

        SnapTaskDO snapTaskData = taskService.selectSnapTaskById(userId).getData();
        scoreInfo = new ReportDataBO.ScoreInfoForTask();
        scoreInfo.setTaskDate(snapTaskData.getCreateTime());
        scoreInfo.addScore("家长评分", snapTaskData.getSnapParentScore());
        scoreInfo.addScore("老师评分", snapTaskData.getSnapTeacherScore());
        taskAndScore.put(AdhdTaskTypeEnum.SNAP_TASK, scoreInfo);

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

        reportData.setTaskBloodOxygenInfo(taskAndBloodOxygen);

        /**
         * 调用 pdfReportService 生成报告
         */
        String pdfAbsPath = pdfReportService.createPdf(reportData);
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