package com.hh.webcollect.system.model.entity;

import com.hh.webcollect.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
@Data
@Entity(name = "user")
public class User extends BaseEntity {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 最后登录时间
     */
    private Date lastLoginDate;
}
