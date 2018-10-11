package com.hh.webcollect.system.service;

import com.hh.webcollect.common.service.BaseService;
import com.hh.webcollect.system.model.bo.PermissionBO;
import com.hh.webcollect.system.model.entity.Permission;
import com.hh.webcollect.system.model.vo.SavePermissionVO;

import java.util.List;

/**
 * @author hongbo.pan
 * @date 2018/9/21
 */
public interface PermissionService extends BaseService<Permission, PermissionBO> {

    /**
     * 新增权限
     *
     * @param permissionVO
     * @return PermissionBO
     */
    PermissionBO savePermission(SavePermissionVO permissionVO);

    /**
     * findByIsDelete
     *
     * @param isDelete
     * @return List<Permission>
     */
    List<Permission> findByIsDelete(Boolean isDelete);

}
