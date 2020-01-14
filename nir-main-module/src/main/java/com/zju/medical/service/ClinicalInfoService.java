package com.zju.medical.service;


import com.zju.medical.common.pojo.xdo.ClinicalInfoDOWithBLOBs;
import com.zju.medical.common.result.ReturnResult;

import javax.validation.constraints.NotNull;

/**
 * @author xiaoguo
 */
public interface ClinicalInfoService {

    /**
     * 添加userId所指代用户的 临床信息 (患病史等)
     * @param clinicalInfoDO
     * @param userId
     */
    void saveClinicalInfo(ClinicalInfoDOWithBLOBs clinicalInfoDO, @NotNull Integer userId);


    /**
     * 根据userId查询此用户的 clinical_info表中的对应数据
     * @param userId
     * @return
     */
    ReturnResult<ClinicalInfoDOWithBLOBs> selectClinicalInfoDataByUserId(Integer userId);


    /**
     * 根据userId更新clinical_info表
     * @param clinicalInfoDo
     * @param userId
     */
    void updateClinicalInfoByUserId(ClinicalInfoDOWithBLOBs clinicalInfoDo, Integer userId);
}
