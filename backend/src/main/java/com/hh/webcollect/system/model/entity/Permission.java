package com.hh.webcollect.system.model.entity;

import com.hh.webcollect.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Data
@Entity(name = "permission")
public class Permission extends BaseEntity {

    /**
     * 权限code
     */
    private String code;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 模块code
     */
    private String moduleCode;

    /**
     * url地址
     */
    private String url;
}
