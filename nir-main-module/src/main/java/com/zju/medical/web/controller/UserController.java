package com.zju.medical.web.controller;

import com.zju.medical.common.pojo.xdo.UserDO;
import com.zju.medical.common.result.ReturnResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by white_wolf on 2020/1/11.
 *
 * @author thebestwj
 */
@RestController
public class UserController {
    @PostMapping(value = "/user")
    public ReturnResult<Integer> addUser(@RequestBody UserDO userDO) {

        //TODO 用户信息存入数据库
        System.out.println('1');

        return new ReturnResult<Integer>(null, null, null);
    }
}
