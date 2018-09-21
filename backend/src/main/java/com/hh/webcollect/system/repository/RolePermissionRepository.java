package com.hh.webcollect.system.repository;

import com.hh.webcollect.common.repository.BaseRepository;
import com.hh.webcollect.system.model.entity.RolePermission;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Repository
public interface RolePermissionRepository extends BaseRepository<RolePermission, Long> {

    /**
     * 角色编号和是否删除查询权限和角色关系
     *
     * @param roleCode
     * @param isDelete
     * @return List<RolePermission>
     */
    List<RolePermission> findByRoleCodeAndIsDelete(String roleCode, Boolean isDelete);

    /**
     * 权限编号和是否删除查询权限和角色关系
     *
     * @param permissionCode
     * @param isDelete
     * @return List<RolePermission>
     */
    List<RolePermission> findByPermissionCodeAndIsDelete(String permissionCode, Boolean isDelete);

    /**
     * 多角色编号和是否删除查询权限和角色关系
     *
     * @param roleCodes
     * @param isDelete
     * @return List<RolePermission>
     */
    List<RolePermission> findByRoleCodeInAndIsDelete(Set<String> roleCodes, Boolean isDelete);
}
