package com.hh.webcollect.system.service.impl;

import com.google.common.collect.Maps;
import com.hh.webcollect.system.model.entity.Permission;
import com.hh.webcollect.system.repository.PermissionRepository;
import com.hh.webcollect.system.service.FilterChainDefinitionsService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author hongbo.pan
 * @date 2018/9/26
 */
@Service
public class FilterChainDefinitionsServiceImpl implements FilterChainDefinitionsService {

    /**
     * 此处不能依赖permissionService，会导致循环依赖
     *
     * Lazy不能破除循环依赖，原因不明
     */
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Map<String, String> loadFilterChainDefinitions() {
        Map<String, String> filterChainDefinitionMap = Maps.newLinkedHashMap();
        Permission perm = new Permission();
        perm.setIsDelete(false);
        List<Permission> permissions = permissionRepository.findAll(Example.of(perm));
        if (CollectionUtils.isNotEmpty(permissions)) {
            for (Permission permission : permissions) {
                String permissionCode = "perms[" + permission.getCode()+ "]";
                filterChainDefinitionMap.put(permission.getUrl(), permissionCode);
            }
        }
        //swagger2
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/v2/api-docs", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");

        filterChainDefinitionMap.put("/doLogin", "anon");
        filterChainDefinitionMap.put("/doLogin", "anon");
        filterChainDefinitionMap.put("/**", "anon");
        return filterChainDefinitionMap;
    }
}
