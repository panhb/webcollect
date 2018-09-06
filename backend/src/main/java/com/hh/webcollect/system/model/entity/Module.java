package com.hh.webcollect.system.model.entity;

import com.hh.webcollect.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
@Data
@Entity(name = "module")
public class Module extends BaseEntity {

    /**
     * 模块code
     */
    private String code;

    /**
     * 模块名称
     */
    private String name;

}
