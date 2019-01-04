package com.hh.webcollect.common;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.hh.webcollect.common.exception.WcException;
import com.hh.webcollect.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @author hongbo.pan
 * @date 2018/9/6
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @Autowired
    private HttpServletRequest request;

    /**
     * 校验参数异常捕获
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public Result exceptionHandler(BindException e) {
        wirteLog(e);
        return Result.err(e.getAllErrors().get(0).getDefaultMessage());
    }

    /**
     * 业务异常捕获
     *
     * @param e
     * @return
     */
    @ExceptionHandler(WcException.class)
    public Result exceptionHandler(WcException e) {
        wirteLog(e);
        return Result.err(e.getCode(), e.getErrMsg());
    }

    /**
     * 系统异常捕获
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {
        wirteLog(e);
        return Result.err(e.getMessage());
    }

    /**
     * 写日志
     *
     * @param e
     * @return
     */
    private void wirteLog(Exception e) {
        log.info("request:" + getRequestString());
        log.error(e.getMessage(), e);
    }

    private String getRequestString() {
        String reqString = request.getQueryString();
        if (Strings.isNullOrEmpty(reqString)) {
            Map<String, String[]> parameters = request.getParameterMap();
            if (parameters != null && !parameters.isEmpty()) {
                reqString = parameter2Json(request.getParameterMap());
            }
        }
        if (Strings.isNullOrEmpty(reqString)) {
            try {
                reqString = new String(IOUtils.toByteArray(request.getInputStream()),"utf-8");
            } catch (IOException e) {
                log.error(e.getMessage(),e);
            }
        }
        return reqString;
    }

    private String parameter2Json(Map<String, String[]> parameters) {
        Map<String, String> map = Maps.newLinkedHashMap();
        for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
            map.put(entry.getKey(), entry.getValue()[0]);
        }
        return JSON.toJSONString(map);
    }

}
