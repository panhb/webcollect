package com.hh.webcollect.system.model.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
@Data
public class SavePermissionVO {

    /**
     * 权限code
     */
    @NotNull(message = "权限code不能为空")
    private String code;

    /**
     * 权限名称
     */
    @NotNull(message = "权限名称不能为空")
    private String name;

    /**
     * 模块code
     */
    @NotNull(message = "模块code不能为空")
    private String moduleCode;

    /**
     * url地址
     */
    @NotNull(message = "url地址不能为空")
    private String url;

}
