package com.hh.webcollect.common.model;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.List;

/**
 * @author hongbo.pan
 * @date 2018/9/7
 */
@Data
public class PageVO extends BaseModel {

    /**
     * 每页显示几条
     * example缺省会导致类型转换异常
     */
    @ApiParam(name = "pageVO.pageSize", value = "每页显示几条", required = true, example = "10")
    private Integer pageSize;

    /**
     * 当前页
     */
    @ApiParam(name = "pageVO.pageNum", value = "当前页", required = true, example = "1")
    private Integer pageNum;

    /**
     * 分页排序规则
     */
    private List<SortVO> sortList;

    public Integer getPageSize() {
        if (pageSize == null) {
            pageSize = 10;
        }
        return pageSize;
    }

    public Integer getPageNum() {
        if (pageNum == null) {
            pageNum = 1;
        }
        return pageNum;
    }
}
