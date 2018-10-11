package com.hh.webcollect.system.model.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
@Data
public class SaveUserRoleVO {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 角色code
     */
    @NotBlank(message = "角色code不能为空")
    private String roleCode;

}
