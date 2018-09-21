package com.hh.webcollect.system.repository;

import com.hh.webcollect.common.repository.BaseRepository;
import com.hh.webcollect.system.model.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Repository
public interface UserRoleRepository extends BaseRepository<UserRole, Long> {

    /**
     * 多用户名和是否删除查询用户和角色关系
     *
     * @param usernames
     * @param isDelete
     * @return List<UserRole>
     */
    List<UserRole> findByUsernameInAndIsDelete(Set<String> usernames, Boolean isDelete);


    /**
     * 用户名和是否删除查询用户和角色关系
     *
     * @param username
     * @param isDelete
     * @return List<UserRole>
     */
    List<UserRole> findByUsernameAndIsDelete(String username, Boolean isDelete);

    /**
     * 角色编号和是否删除查询用户和角色关系
     *
     * @param roleCode
     * @param isDelete
     * @return List<UserRole>
     */
    List<UserRole> findByRoleCodeAndIsDelete(String roleCode, Boolean isDelete);

}
