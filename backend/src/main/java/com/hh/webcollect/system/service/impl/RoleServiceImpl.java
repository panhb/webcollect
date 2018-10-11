package com.hh.webcollect.system.service.impl;

import com.hh.webcollect.common.service.BaseServiceImpl;
import com.hh.webcollect.common.util.BeanUtil;
import com.hh.webcollect.system.model.bo.RoleBO;
import com.hh.webcollect.system.model.entity.Role;
import com.hh.webcollect.system.model.vo.SaveRoleVO;
import com.hh.webcollect.system.repository.RoleRepository;
import com.hh.webcollect.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hongbo.pan
 * @date 2018/9/21
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleBO> implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleBO saveRole(SaveRoleVO roleVO) {
        Role role = roleRepository.saveWithDate(BeanUtil.copyBean(roleVO, Role.class));
        return BeanUtil.copyBean(role, RoleBO.class);
    }

    @Override
    public RoleBO findByCode(String code) {
        Role role = roleRepository.findByCodeAndIsDelete(code, false);
        if (role != null) {
            return BeanUtil.copyBean(role, RoleBO.class);
        }
        return null;
    }
}
