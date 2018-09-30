package com.hh.webcollect.system.model.bo;

import com.hh.webcollect.common.model.BaseBO;
import lombok.Data;

/**
 * @author hongbo.pan
 * @date 2018/9/28
 */
@Data
public class PropertyBO extends BaseBO {

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
