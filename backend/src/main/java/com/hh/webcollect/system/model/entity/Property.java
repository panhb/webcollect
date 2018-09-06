package com.hh.webcollect.system.model.entity;

import com.hh.webcollect.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Data
@Entity(name = "property")
public class Property extends BaseEntity {

    /**
     * 属性类型code
     */
    private String propertyTypeCode;

    /**
     * 属性code
     */
    private String code;

    /**
     * 属性名称
     */
    private String name;

    /**
     * 顺序
     */
    private Integer sortOrder;
}
