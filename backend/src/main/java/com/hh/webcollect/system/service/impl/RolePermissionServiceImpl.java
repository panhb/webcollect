package com.hh.webcollect.system.service.impl;

import com.hh.webcollect.common.service.BaseServiceImpl;
import com.hh.webcollect.system.model.bo.RolePermissionBO;
import com.hh.webcollect.system.model.entity.RolePermission;
import com.hh.webcollect.system.repository.RolePermissionRepository;
import com.hh.webcollect.system.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author hongbo.pan
 * @date 2018/9/21
 */
@Service
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermission, RolePermissionBO> implements RolePermissionService {

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Override
    public List<RolePermission> findByRoleCode(String roleCode) {
        return rolePermissionRepository.findByRoleCodeAndIsDelete(roleCode, false);
    }

    @Override
    public List<RolePermission> findByPermissionCode(String permissionCode) {
        return rolePermissionRepository.findByPermissionCodeAndIsDelete(permissionCode, false);
    }

    @Override
    public List<RolePermission> findByRoleCodeIn(Set<String> roleCodes) {
        return rolePermissionRepository.findByRoleCodeInAndIsDelete(roleCodes, false);
    }

}
