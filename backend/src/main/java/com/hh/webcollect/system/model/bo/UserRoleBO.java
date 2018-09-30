package com.hh.webcollect.system.model.bo;

import com.hh.webcollect.common.model.BaseBO;
import lombok.Data;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Data
public class UserRoleBO extends BaseBO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 角色code
     */
    private String roleCode;
}
