package com.hh.webcollect.common;

import com.hh.webcollect.common.exception.WcException;
import com.hh.webcollect.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hongbo.pan
 * @date 2018/9/6
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(WcException.class)
    @ResponseBody
    public Result exceptionHandler(WcException e) {
        log.error(e.getMessage(),e);
        return Result.err(e.getCode(), e.getErrMsg());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e) {
        log.error(e.getMessage(),e);
        return Result.err(e.getMessage());
    }

}
