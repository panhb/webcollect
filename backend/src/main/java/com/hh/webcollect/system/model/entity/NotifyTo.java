package com.hh.webcollect.system.model.entity;

import com.hh.webcollect.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Data
@Entity(name = "notify_to")
public class NotifyTo extends BaseEntity {

    /**
     * 通知类型
     */
    private Long notifyId;

    /**
     * 角色code或用户名
     */
    private String roleUser;

    /**
     * NotifyToTypeEnum
     */
    private String type;

    /**
     * 是否已读
     */
    private Boolean hasRead;
}
