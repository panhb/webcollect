package com.hh.webcollect.system.model.entity;

import com.hh.webcollect.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
@Data
@Entity(name = "role")
public class Role extends BaseEntity {

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

}
