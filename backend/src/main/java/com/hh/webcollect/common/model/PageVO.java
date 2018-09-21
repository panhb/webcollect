package com.hh.webcollect.common.model;

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
     */
    private Integer pageSize;

    /**
     * 当前页
     */
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
