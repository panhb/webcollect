package com.hh.webcollect.common.model;

import lombok.Data;

import java.util.Date;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
@Data
public class BaseVO extends BaseModel {

    private Long id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建人id
     */
    private Long createUserId;

    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 修改时间
     */
    private Date modifyDate;

    /**
     * 修改人id
     */
    private Long modifyUserId;

    /**
     * 修改人名称
     */
    private String modifyUserName;

    /**
     * 状态
     */
    private String status;

    /**
     * 是否删除
     */
    private Boolean isDelete;

    /**
     * 备注
     */
    private String remark;
}
