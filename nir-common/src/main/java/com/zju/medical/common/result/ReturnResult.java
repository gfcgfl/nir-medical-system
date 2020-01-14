package com.zju.medical.common.result;

import lombok.Data;

/**
 * @ClassName: ReturnResult
 * @Description:
 * @CreatedBy: xiaoguo
 * @CreatedAt: 2019/8/5 21:00
 **/
@Data
public class ReturnResult<T> {
    String msg;
    String code;
    T data;


    public static final ReturnResult<Integer> FAILED = new ReturnResult<>(ResultCodeEnum.FAIL);

    public ReturnResult() {
    }


    public ReturnResult(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public ReturnResult(String msg, String code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public ReturnResult(ResultCodeEnum resultCodeEnum) {
        this.msg = resultCodeEnum.getMsg();
        this.code = resultCodeEnum.getCode();
    }

    public ReturnResult(ResultCodeEnum resultCodeEnum, T data) {
        this.msg = resultCodeEnum.getMsg();
        this.code = resultCodeEnum.getCode();
        this.data = data;
    }





}