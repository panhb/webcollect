package com.hh.webcollect.common.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
@Data
@MappedSuperclass
public class BaseEntity extends BaseModel {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建人
     */
    private Long createUserId;

    /**
     * 创建人
     */
    private Long createUserName;

    /**
     * 修改时间
     */
    private Date modifyDate;

    /**
     * 修改人
     */
    private Long modifyUserId;

    /**
     * 修改人
     */
    private Long modifyUserName;

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
