package com.hh.webcollect.common.model;

import com.hh.webcollect.common.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hongbo.pan
 * @date 2018/9/6
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> extends BaseModel {

    /**
     * 返回码
     */
    private int code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 详细信息
     */
    private T data;

    public static <T> Result<T> err(String msg){
        return err(Constant.FAIL, msg);
    }

    public static <T> Result<T> err(int code, String msg){
        return new Result<>(code, msg, null);
    }

    public static <T> Result<T> succ(){
        return succ(null);
    }

    public static <T> Result<T> succ(T data){
        return new Result<>(Constant.SUCCESS, Constant.SUCCESS_MSG, data);
    }

}
