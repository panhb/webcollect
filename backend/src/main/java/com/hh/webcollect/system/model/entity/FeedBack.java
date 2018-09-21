package com.hh.webcollect.system.model.entity;

import com.hh.webcollect.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
@Data
@Entity(name = "feed_back")
public class FeedBack extends BaseEntity {

    /**
     * 反馈类型
     */
    private String type;

    /**
     * 反馈内容
     */
    private String content;

    /**
     * 回复email地址
     */
    private String email;

    /**
     * 反馈文件地址
     */
    private String filePath;

}
