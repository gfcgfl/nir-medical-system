package com.zju.medical.service;


import com.zju.medical.common.pojo.bo.ReportDataBO;
import com.zju.medical.common.xenum.AdhdTaskTypeEnum;

import java.util.List;
import java.util.Map;

/**
 * @author xiaoguo
 */
public interface BloodOxygenWaveformImgService {



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
     * 根据每个任务的血氧数据画出波形图，存为文件后返回文件绝对路径
     * 每个任务AdhdTaskTypeEnum 生成n个图片（对应n个路径,放在list中）
     * @param taskBloodOxygenInfo
     * @param imgFileNamePrefix  保存的图片文件名的前缀
     * @return
     */
    Map<AdhdTaskTypeEnum, List<String>> createImgFile(
            Map<AdhdTaskTypeEnum, ReportDataBO.BloodOxygenInfoForTask> taskBloodOxygenInfo,
            String imgFileNamePrefix);

}
