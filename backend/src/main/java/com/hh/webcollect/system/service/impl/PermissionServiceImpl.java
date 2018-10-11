package com.hh.webcollect.system.service.impl;

import com.hh.webcollect.common.service.BaseServiceImpl;
import com.hh.webcollect.common.util.BeanUtil;
import com.hh.webcollect.system.model.bo.PermissionBO;
import com.hh.webcollect.system.model.entity.Permission;
import com.hh.webcollect.system.model.vo.SavePermissionVO;
import com.hh.webcollect.system.repository.PermissionRepository;
import com.hh.webcollect.system.service.PermissionService;
import com.hh.webcollect.system.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hongbo.pan
 * @date 2018/9/21
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission, PermissionBO> implements PermissionService {

    @Autowired
    private ShiroService shiroService;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PermissionBO savePermission(SavePermissionVO permissionVO) {
        PermissionBO permissionBO = BeanUtil.copyBean(permissionVO, PermissionBO.class);
        Permission permission = save(BeanUtil.copyBean(permissionBO, Permission.class));
        shiroService.updatePermission();
        return BeanUtil.copyBean(permission, PermissionBO.class);
    }

    @Override
    public List<Permission> findByIsDelete(Boolean isDelete) {
        return permissionRepository.findByIsDelete(isDelete);
    }

}
