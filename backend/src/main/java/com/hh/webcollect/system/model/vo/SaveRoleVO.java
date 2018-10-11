package com.hh.webcollect.system.model.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
@Data
public class SaveRoleVO {

    /**
     * 角色编码
     */
    @NotBlank(message = "角色编码不能为空")
    private String code;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空")
    private String name;

}
