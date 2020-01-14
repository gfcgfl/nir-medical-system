package com.zju.medical.web.controller;

import com.zju.medical.common.pojo.vo.TaskDataAndMarkVO;
import com.zju.medical.common.result.ReturnResult;
import com.zju.medical.common.utils.JsonUtils;
import com.zju.medical.nir.biz.MarkService;
import com.zju.medical.service.BloodOxygenDataPathService;
import com.zju.medical.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by white_wolf on 2020/1/11.
 *
 * @author thebestwj
 */

@RestController
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    MarkService markService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private BloodOxygenDataPathService bloodOxygenDataPathService;

    @PostMapping(value = "/task")
    public ReturnResult<Integer> addAdhdTask(@RequestParam("file") MultipartFile file, String data) {

        TaskDataAndMarkVO taskDataAndMark = JsonUtils.objectFromJson(data, TaskDataAndMarkVO.class);
//        if (true){
//            return new ReturnResult<>("ok", "true", null);
//
//        }
        String RPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String tempFilePath = "temp.txt";
        File tempFile = new File(RPath, tempFilePath);
//        File tempFile = null;
//        try {
//            tempFile = cpr.getFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            tempFile = cpr.getFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        if (!tempFile.exists()) {
            try {
                tempFile.createNewFile();
            } catch (IOException e) {
                logger.warn("创建文件失败");
                e.printStackTrace();
            }
        }

        try {
            file.transferTo(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(taskDataAndMark.getMarks());
        String absPath = markService.doMark(taskDataAndMark.getMarks(), tempFile);

        //将TASK信息存入数据库
        String whichTask = String.valueOf(taskDataAndMark.getTaskId());
        ReturnResult<Integer> taskResult = taskService.addTask(whichTask, taskDataAndMark);

        if (!taskResult.getCode().equals("true")) {
            return taskResult;
        }

        //血氧数据路径写入
        ReturnResult<Integer> dataPathResult
                = bloodOxygenDataPathService.addOrUpdateDataPath(taskDataAndMark.getUserId(), whichTask, absPath);

        return dataPathResult;
    }
}
