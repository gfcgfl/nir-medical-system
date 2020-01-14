package com.zju.medical.service;


import com.zju.medical.common.pojo.xdo.BloodOxygenDO;
import com.zju.medical.common.result.ReturnResult;

public interface BloodOxygenDataPathService {

    ReturnResult<Integer> addOrUpdateDataPath(int userId, String whichTask, String dataFileAbsPath);

    ReturnResult<Integer> addOrUpdateDataPath(BloodOxygenDO bloodOxygenDO, int userId);

    ReturnResult<BloodOxygenDO> selectDataPath(int userId);
}
