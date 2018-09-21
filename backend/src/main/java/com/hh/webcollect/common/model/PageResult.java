package com.hh.webcollect.common.model;

import lombok.Data;

import java.util.List;

/**
 * @author hongbo.pan
 * @date 2018/9/7
 */
@Data
public class PageResult<T> extends BaseModel {

    /**
     * 总分页数
     */
    private int totalPages;

    /**
     * 总数量
     */
    private long totalElements;

    /**
     * 数据
     */
    private List<T> content;

}
