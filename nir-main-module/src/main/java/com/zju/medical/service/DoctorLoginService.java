package com.zju.medical.service;


import com.zju.medical.common.pojo.vo.DoctorVO;
import com.zju.medical.common.pojo.xdo.DoctorDO;
import com.zju.medical.common.result.ReturnResult;

import java.util.List;

/**
 * @author xiaoguo
 */
public interface DoctorLoginService {

    /**
     * 医生登录
     * @param
     * @return
     */
    ReturnResult<Integer> login(String username, String password);

    ReturnResult<List<DoctorDO>> selectList();

    ReturnResult<Boolean> addUser(DoctorVO doctorVO);

    ReturnResult<Boolean> deleteUserById(Integer id);
}
