package com.hh.webcollect.common.model;

import lombok.Data;

/**
 * @author hongbo.pan
 * @date 2018/9/7
 */
@Data
public class SortVO extends BaseModel {

    /**
     * 排序方向：asc、desc
     */
    private String type;

    /**
     * 排序字段名称
     */
    private String name;

}
