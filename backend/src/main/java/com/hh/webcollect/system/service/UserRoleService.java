package com.hh.webcollect.system.service;

import com.hh.webcollect.common.service.BaseService;
import com.hh.webcollect.system.model.bo.UserRoleBO;
import com.hh.webcollect.system.model.entity.UserRole;
import com.hh.webcollect.system.model.vo.SaveUserRoleVO;

import java.util.List;
import java.util.Set;

/**
 * @author hongbo.pan
 * @date 2018/9/21
 */
public interface UserRoleService extends BaseService<UserRole, UserRoleBO> {

    /**
     * 多用户名查询用户和角色关系
     *
     * @param usernames
     * @return List<UserRole>
     */
    List<UserRole> findByUsernameIn(Set<String> usernames);

    /**
     * 根据用户名查询用户和角色关系
     *
     * @param username
     * @return List<UserRole>
     */
    List<UserRole> findByUsername(String username);

    /**
     * 根据角色编号查询用户和角色关系
     *
     * @param roleCode
     * @return List<UserRole>
     */
    List<UserRole> findByRoleCode(String roleCode);

    /**
     * 用户名查询角色code
     *
     * @param username
     * @return List<UserRole>
     */
    Set<String> findRoleCodesByUsername(String username);

    /**
     * saveUserRole
     *
     * @param saveUserRoleVOList
     * @return List<UserRoleBO>
     */
    List<UserRoleBO> saveUserRole(List<SaveUserRoleVO> saveUserRoleVOList);

    /**
     * findByUsernameAndRoleCode
     *
     * @param username
     * @param roleCode
     * @return List<UserRole>
     */
    UserRoleBO findByUsernameAndRoleCode(String username, String roleCode);

}
