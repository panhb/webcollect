package com.hh.webcollect.system.model.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
@Data
public class AddUserVO {

    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotNull(message = "密码")
    private String password;

    /**
     * 用户昵称
     */
    @NotNull(message = "用户昵称不能为空")
    private String nickname;

    /**
     * 备注
     */
    private String remark;

}
