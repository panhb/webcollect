package com.hh.webcollect.common.enums.error.system;

import com.hh.webcollect.common.enums.error.ErrorCode;

/**
 * @author hongbo.pan
 * @date 2018/9/6
 *
 * 系统管理异常枚举
 */
public enum SystemErrorCode implements ErrorCode {

    /**
     * 密码错误
     */
    PASSWORD_ERROR(100001,"密码错误"),

    /**
     * 用户不存在
     */
    USER_IS_NOT_EXIST(100002,"用户不存在"),

    /**
     * 用户不存在
     */
    USER_IS_LOCKED(100003,"用户被冻结");

    private int code;

    private String msg;

    SystemErrorCode(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
