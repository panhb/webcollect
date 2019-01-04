package com.hh.webcollect.system.model.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
@Data
public class LoginVO {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

}
