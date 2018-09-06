package com.hh.webcollect.system.model.entity;

import com.hh.webcollect.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Data
@Entity(name = "role_permission")
public class RolePermission extends BaseEntity {

    /**
     * 角色code
     */
    private String roleCode;

    /**
     * 模块编码
     */
    private String permissionCode;
}
