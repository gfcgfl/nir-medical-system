package com.zju.medical.controller;

import com.zju.medical.common.pojo.vo.UserVO;
import com.zju.medical.common.pojo.xdo.UserDO;
import com.zju.medical.common.result.ReturnResult;
import com.zju.medical.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by white_wolf on 2020/1/11.
 *
 * @author thebestwj
 */
@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping(value = "/user")
    public ReturnResult<Integer> addUser(@RequestBody UserVO user) {

        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(user, userDO);
        Date date = new Date();
        userDO.setCreateTime(date);
        userDO.setUpdateTime(date);

        ReturnResult<Integer> result = userService.saveUser(userDO);

        return result;
    }
}
