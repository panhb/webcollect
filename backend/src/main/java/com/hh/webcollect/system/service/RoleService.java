package com.hh.webcollect.system.service;

import com.hh.webcollect.common.service.BaseService;
import com.hh.webcollect.system.model.bo.RoleBO;
import com.hh.webcollect.system.model.entity.Role;
import com.hh.webcollect.system.model.vo.SaveRoleVO;

/**
 * @author hongbo.pan
 * @date 2018/9/21
 */
public interface RoleService extends BaseService<Role, RoleBO> {

    /**
     * 新增角色
     *
     * @param roleVO
     * @return
     */
    RoleBO saveRole(SaveRoleVO roleVO);

    /**
     * findByCode
     *
     * @param code
     * @return RoleBO
     */
    RoleBO findByCode(String code);
}
