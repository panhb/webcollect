package com.hh.webcollect.system.model.entity;

import com.hh.webcollect.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Data
@Entity(name = "notify")
public class Notify extends BaseEntity {

    /**
     * 通知类型
     */
    private String type;

    /**
     * 主题
     */
    private String subject;

    /**
     * 内容
     */
    private String content;

    /**
     * 是否发布
     */
    private Boolean isPublish;

    /**
     * 是否置顶
     */
    private Boolean isTop;
}
