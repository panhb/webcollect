package com.hh.webcollect.system.model.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.hh.webcollect.common.model.BaseBO;
import lombok.Data;

import java.util.Date;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
@Data
public class UserBO extends BaseBO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    @JSONField(serialize = false)
    private String password;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 最后登录时间
     */
    private Date lastLoginDate;

    /**
     * shiro-redis需要一个主键标识
     * @return
     */
    @Override
    public Long getId() {
        return super.getId();
    }


}
