package com.hh.webcollect.common.exception;

import com.hh.webcollect.common.Constant;
import com.hh.webcollect.common.enums.error.ErrorCode;

/**
 * @author hongbo.pan
 * @date 2018/9/6
 */
public class WcException extends RuntimeException {

    /**
     * 非业务异常， 默认0
     */
    private int code = Constant.FAIL;
    private String errMsg;

    public WcException(String errMsg) {
        super(errMsg);
    }

    public WcException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
        this.errMsg = errorCode.getMsg();
    }

    public WcException(String errMsg, Throwable e) {
        super(errMsg, e);
        this.errMsg = errMsg;
    }

    public WcException(ErrorCode errorCode, Throwable e) {
        this(errorCode.getMsg(), e);
        this.code = errorCode.getCode();
        this.errMsg = errorCode.getMsg();
    }

    public WcException(Throwable e) {
        super(e);
    }

    public int getCode() {
        return code;
    }

    public String getErrMsg() {
        return errMsg;
    }

}
