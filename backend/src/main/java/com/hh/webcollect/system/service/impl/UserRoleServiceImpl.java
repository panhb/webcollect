package com.hh.webcollect.system.service.impl;

import com.google.common.collect.Sets;
import com.hh.webcollect.common.service.BaseServiceImpl;
import com.hh.webcollect.system.model.bo.UserRoleBO;
import com.hh.webcollect.system.model.entity.UserRole;
import com.hh.webcollect.system.repository.UserRoleRepository;
import com.hh.webcollect.system.service.UserRoleService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author hongbo.pan
 * @date 2018/9/21
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole, UserRoleBO> implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> findByUsernameIn(Set<String> usernames) {
        return userRoleRepository.findByUsernameInAndIsDelete(usernames, false);
    }

    @Override
    public List<UserRole> findByUsername(String username) {
        return userRoleRepository.findByUsernameAndIsDelete(username, false);
    }

    @Override
    public List<UserRole> findByRoleCode(String roleCode) {
        return userRoleRepository.findByRoleCodeAndIsDelete(roleCode, false);
    }

    @Override
    public Set<String> findRoleCodesByUsername(String username) {
        Set<String> roleCodes = Sets.newLinkedHashSet();
        List<UserRole> list = findByUsername(username);
        if (CollectionUtils.isNotEmpty(list)) {
            for (UserRole userRole : list) {
                roleCodes.add(userRole.getRoleCode());
            }
        }
        return roleCodes;
    }
}
