package com.hh.webcollect.system.model.entity;

import com.hh.webcollect.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Data
@Entity(name = "property_type")
public class PropertyType extends BaseEntity {

    /**
     * 系统属性类型code
     */
    private String code;

    /**
     * 系统属性类型名称
     */
    private String name;
}
