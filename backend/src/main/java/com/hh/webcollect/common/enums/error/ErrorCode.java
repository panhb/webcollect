package com.hh.webcollect.common.enums.error;

/**
 * @author hongbo.pan
 * @date 2018/9/6
 */
public interface ErrorCode {

    /**
     * 错误码
     *
     * @return int
     */
    int getCode();

    /**
     * 错误信息
     *
     * @return String
     */
    String getMsg();
}
