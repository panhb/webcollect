package com.hh.webcollect.common.model;

import io.swagger.annotations.ApiParam;
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
    @ApiParam(name = "pageVO.sortList[0].type", value = "排序方向：asc、desc")
    private String type;

    /**
     * 排序字段名称
     */
    @ApiParam(name = "pageVO.sortList[0].name", value = "排序字段名称")
    private String name;

}
