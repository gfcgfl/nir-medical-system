package com.zju.medical.common.result;

/**
 * @Description:
 * @Params:
 * @Return:
 * @CreatedAt: 2019/8/5 21:03
 */
public enum ResultCodeEnum {

    //成功
    SUCCESS("true", "success"),
    //空结果集
    EMPTY_RESULT("true", "empty_result"),
    //用户通用异常
    USER_ERROR("false", "用户通用异常"),
    //图片错误
    PIC_FALSE("false", "图片错误"),
    //数据库错误
    SQL_FALSE("false", "数据库错误"),
    //通用异常
    FAIL("false", "通用异常");

    String code;

    String msg;

    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "code: " + this.getCode() + ", msg: " + this.getMsg();
    }
}
