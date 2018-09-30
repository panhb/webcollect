package com.hh.webcollect.system.model.bo;

import com.hh.webcollect.common.model.BaseBO;
import lombok.Data;

/**
 * @author hongbo.pan
 * @date 2018/9/28
 */
@Data
public class NotifyToBO extends BaseBO {

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
