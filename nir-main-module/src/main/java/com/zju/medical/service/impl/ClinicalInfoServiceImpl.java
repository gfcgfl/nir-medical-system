package com.zju.medical.service.impl;


import com.zju.medical.common.pojo.xdo.ClinicalInfoDO;
import com.zju.medical.common.pojo.xdo.ClinicalInfoDOExample;
import com.zju.medical.common.pojo.xdo.ClinicalInfoDOWithBLOBs;
import com.zju.medical.common.result.ResultCodeEnum;
import com.zju.medical.common.result.ReturnResult;
import com.zju.medical.dao.mapper.ClinicalInfoMapper;
import com.zju.medical.service.ClinicalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author xiaoguo
 */
@Service
public class ClinicalInfoServiceImpl implements ClinicalInfoService {

    @Autowired
    private ClinicalInfoMapper clinicalInfoMapper;
    /**
     * 添加userId所指代用户的 临床信息 (患病史等)
     * @param clinicalInfoDO
     * @param userId
     */
    @Override
    public void saveClinicalInfo(ClinicalInfoDOWithBLOBs clinicalInfoDO, @NotNull Integer userId) {
//        ClinicalInfoDOExample example = new ClinicalInfoDOExample();
//        example.createCriteria().andUserIdEqualTo(userId);
        clinicalInfoDO.setUserId(userId);
        Date date = new Date();
        clinicalInfoDO.setCreateTime(date);
        clinicalInfoDO.setUpdateTime(date);
        clinicalInfoMapper.insertSelective(clinicalInfoDO);
    }


    /**
     * 根据userId查询此用户的 clinical_info表中的对应数据
     * @param userId
     * @return
     */
    @Override
    public ReturnResult<ClinicalInfoDOWithBLOBs> selectClinicalInfoDataByUserId(Integer userId) {
        try{
            ClinicalInfoDOExample example = new ClinicalInfoDOExample();
            ClinicalInfoDOExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            List<ClinicalInfoDOWithBLOBs> clinicalInfoDoWithBlobsList = clinicalInfoMapper.selectByExampleWithBLOBs(example);
            if (CollectionUtils.isEmpty(clinicalInfoDoWithBlobsList)) {
                return new ReturnResult<>(ResultCodeEnum.EMPTY_RESULT);
            }

            return new ReturnResult<>(ResultCodeEnum.SUCCESS, clinicalInfoDoWithBlobsList.get(0));
        }catch (Exception e){
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }


    /**
     * 根据userId更新clinical_info表
     * @param clinicalInfoDo
     * @param userId
     */
    @Override
    public void updateClinicalInfoByUserId(ClinicalInfoDOWithBLOBs clinicalInfoDo, Integer userId) {
        ClinicalInfoDOExample example = new ClinicalInfoDOExample();
        ClinicalInfoDOExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<ClinicalInfoDO> clinicalInfoDOList = clinicalInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(clinicalInfoDOList)) {
            this.saveClinicalInfo(clinicalInfoDo, userId);
        } else  {
            clinicalInfoDo.setUpdateTime(new Date());
            clinicalInfoMapper.updateByExampleSelective(clinicalInfoDo, example);
        }

    }
}
