package com.hh.webcollect.system.model.entity;

import com.hh.webcollect.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Data
@Entity(name = "user_role")
public class UserRole extends BaseEntity {

    /**
     * 用户名
     */
    private String username;

    /**
     * 角色code
     */
    private String roleCode;
}
