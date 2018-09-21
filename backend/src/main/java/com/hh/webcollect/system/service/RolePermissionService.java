package com.hh.webcollect.system.service;

import com.hh.webcollect.common.service.BaseService;
import com.hh.webcollect.system.model.bo.RolePermissionBO;
import com.hh.webcollect.system.model.entity.RolePermission;

import java.util.List;
import java.util.Set;

/**
 * @author hongbo.pan
 * @date 2018/9/21
 */
public interface RolePermissionService extends BaseService<RolePermission, RolePermissionBO> {

    /**
     * 根据角色编号查询角色和权限关系
     *
     * @param roleCode
     * @return List<RolePermission>
     */
    List<RolePermission> findByRoleCode(String roleCode);

    /**
     * 根据权限编号查询角色和权限关系
     *
     * @param permissionCode
     * @return List<RolePermission>
     */
    List<RolePermission> findByPermissionCode(String permissionCode);

    /**
     * 多角色编号查询角色和权限关系
     *
     * @param roleCodes
     * @return List<RolePermission>
     */
    List<RolePermission> findByRoleCodeIn(Set<String> roleCodes);

}
