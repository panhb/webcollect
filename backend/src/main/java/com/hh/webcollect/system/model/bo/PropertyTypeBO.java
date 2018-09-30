package com.hh.webcollect.system.model.bo;

import com.hh.webcollect.common.model.BaseBO;
import lombok.Data;

/**
 * @author hongbo.pan
 * @date 2018/9/28
 */
@Data
public class PropertyTypeBO extends BaseBO {

    /**
     * 系统属性类型code
     */
    private String code;

    /**
     * 系统属性类型名称
     */
    private String name;
}
