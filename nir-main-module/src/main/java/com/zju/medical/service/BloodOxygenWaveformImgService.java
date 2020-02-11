package com.zju.medical.service;


import com.zju.medical.common.pojo.bo.ReportDataBO;
import com.zju.medical.common.xenum.AdhdTaskTypeEnum;
import com.zju.medical.config.ReportImageConfig;

import java.util.List;
import java.util.Map;

/**
 * @author xiaoguo
 */
public interface BloodOxygenWaveformImgService {

    String DRAW_WITH_JAVA = "JAVA";
    String DRAW_WITH_PYTHON = "PYTHON";



    /**
     * 判断指定名称的文件是否已经存在
     * @param imgName
     * @return
     */
    boolean alreadyExists(String imgName);


    /**
     * 删除指定名称的临时文件
     * @param imgName
     * @return
     */
    boolean deleteExistImg(String imgName);


    /**
     * 根据每个任务的血氧数据画出波形图，（存为文件后）返回文件绝对路径
     * 每个任务AdhdTaskTypeEnum 生成n个图片（对应n个路径,放在list中）
     * @param taskBloodOxygenInfo 存储了每一个任务AdhdTaskTypeEnum，对应的血氧数据信息BloodOxygenInfoForTask
     * @param userIdString 用户id的字符串形式
     * @return Map结构。 key：哪一个任务； value：此任务生成的n个图片的绝对路径列表
     */
    Map<AdhdTaskTypeEnum, List<String>> createImgFile(
            Map<AdhdTaskTypeEnum, ReportDataBO.BloodOxygenInfoForTask> taskBloodOxygenInfo,
            String userIdString,
            ReportImageConfig config);

}
