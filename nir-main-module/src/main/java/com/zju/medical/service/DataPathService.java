package com.zju.medical.service;


import com.zju.medical.common.pojo.xdo.BloodOxygenDO;
import com.zju.medical.common.result.ReturnResult;

public interface DataPathService {

    ReturnResult<Integer> addOrUpdateDataPath(BloodOxygenDO bloodOxygenDO, int userId);

    ReturnResult<BloodOxygenDO> selectDataPath(int userId);
}
