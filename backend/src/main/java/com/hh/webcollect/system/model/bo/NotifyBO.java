package com.hh.webcollect.system.model.bo;

import com.hh.webcollect.common.model.BaseBO;
import lombok.Data;

/**
 * @author hongbo.pan
 * @date 2018/9/28
 */
@Data
public class NotifyBO extends BaseBO {

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
