package com.zju.medical.service.impl;


import com.zju.medical.common.pojo.xdo.BloodOxygenDO;
import com.zju.medical.common.pojo.xdo.BloodOxygenDOExample;
import com.zju.medical.common.result.ResultCodeEnum;
import com.zju.medical.common.result.ReturnResult;
import com.zju.medical.dao.mapper.BloodOxygenMapper;
import com.zju.medical.service.BloodOxygenDataPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

import static com.zju.medical.common.constant.AdhdTaskConstant.*;

/**
 *  by zys 20191022
 */
@Service
public class BloodOxygenDataPathServiceImpl implements BloodOxygenDataPathService {

    @Autowired
    private BloodOxygenMapper bloodOxygenMapper;

    @Override
    public ReturnResult<Integer> addOrUpdateDataPath(int userId, String whichTask, String dataFileAbsPath) {

        BloodOxygenDO bloodOxygenDO = new BloodOxygenDO();
        switch (whichTask) {
            case REY_COMPLEX_FIGURE_MEMORY: {
                bloodOxygenDO.setDataPath1(dataFileAbsPath);
                break;
            }
            case DIGIT_ALPHABET_LINKING: {
                // 数字字母连线任务也就是 word task
                bloodOxygenDO.setDataPath2(dataFileAbsPath);
                break;
            }
            case STROOP_COLOR_WORDS: {
                bloodOxygenDO.setDataPath3(dataFileAbsPath);
                break;
            }
            case RESTING_STATE: {
                // task quiet也就是resting task
                bloodOxygenDO.setDataPath4(dataFileAbsPath);
                break;
            }
            case SNAP_SCORE:
            default: {

                return ReturnResult.FAILED;
            }
        }

        ReturnResult<Integer> result = this.addOrUpdateDataPath(bloodOxygenDO, userId);
        return result;
    }

    @Override
    public ReturnResult<Integer> addOrUpdateDataPath(BloodOxygenDO bloodOxygenDO, int userId) {
        try{
            BloodOxygenDOExample bloodOxygenDOExample = new BloodOxygenDOExample();
            BloodOxygenDOExample.Criteria criteria = bloodOxygenDOExample.createCriteria();
            criteria.andUserIdEqualTo(userId);
            List<BloodOxygenDO> result = bloodOxygenMapper.selectByExample(bloodOxygenDOExample);
            bloodOxygenDO.setUserId(userId);
            if (CollectionUtils.isEmpty(result)){
                bloodOxygenDO.setCreateTime(new Date());
                bloodOxygenMapper.insertSelective(bloodOxygenDO);
            }else {
                bloodOxygenMapper.updateByExampleSelective(bloodOxygenDO, bloodOxygenDOExample);
            }
        }catch (Exception e){
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
        return new ReturnResult<>(ResultCodeEnum.SUCCESS);
    }

    @Override
    public ReturnResult<BloodOxygenDO> selectDataPath(int userId) {
        try{
            BloodOxygenDOExample bloodOxygenDOExample = new BloodOxygenDOExample();
            BloodOxygenDOExample.Criteria criteria = bloodOxygenDOExample.createCriteria();
            criteria.andUserIdEqualTo(userId);
            List<BloodOxygenDO> result = bloodOxygenMapper.selectByExample(bloodOxygenDOExample);
            if (CollectionUtils.isEmpty(result)){
                return new ReturnResult<>(ResultCodeEnum.EMPTY_RESULT);
            }else {
                return new ReturnResult<>(ResultCodeEnum.SUCCESS, result.get(0));
            }
        }catch (Exception e){
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }
}
