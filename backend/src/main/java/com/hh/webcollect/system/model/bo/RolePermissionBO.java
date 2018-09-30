package com.hh.webcollect.system.model.bo;

import com.hh.webcollect.common.model.BaseBO;
import lombok.Data;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Data
public class RolePermissionBO extends BaseBO {

    /**
     * 角色code
     */
    private String roleCode;

    /**
     * 模块编码
     */
    private String permissionCode;
}
