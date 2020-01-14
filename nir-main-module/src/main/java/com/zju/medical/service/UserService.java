package com.zju.medical.service;


import com.zju.medical.common.pojo.bo.DataStaticsBO;
import com.zju.medical.common.pojo.xdo.UserDO;
import com.zju.medical.common.result.ReturnResult;

import java.util.List;

/**
 * @author xiaoguo
 */
public interface UserService {

    /**
     * 添加用户
     * @param userDo
     * @return
     */
    ReturnResult<Integer> saveUser(UserDO userDo);


    /**
     * 获取所有的用户的数据
     * @return
     */
    List<UserDO> listAllUsers();

    ReturnResult<List<UserDO>> listUsersByCondition(String number, String dateStart, String dateEnd);

    /**
     * 根据userId更新user表
     * @param userDo
     * @param userId
     */
    void updateUserByUserId(UserDO userDo, Integer userId);

    UserDO selectUserById(Integer id);

    ReturnResult<DataStaticsBO> fetchStaticsData();

    ReturnResult<Integer> updateAdhdTypeById(int adhdType, int userId);

    ReturnResult<Integer> deleteById(int id, int userId);
}
