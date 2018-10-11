package com.hh.webcollect.system.service;

import com.hh.webcollect.common.model.PageResult;
import com.hh.webcollect.common.service.BaseService;
import com.hh.webcollect.system.model.bo.UserBO;
import com.hh.webcollect.system.model.entity.User;
import com.hh.webcollect.system.model.vo.QueryUserVO;
import com.hh.webcollect.system.model.vo.SaveUserVO;

import java.util.Set;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
public interface UserService extends BaseService<User, UserBO> {

    /**
     * 新增用户
     *
     * @param userVO
     * @return
     */
    UserBO saveUser(SaveUserVO userVO);

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return UserBO
     */
    UserBO findByUsername(String username);

    /**
     * 根据用户昵称查找用户
     *
     * @param nickname
     * @return UserBO
     */
    UserBO findByNickname(String nickname);

    /**
     * 用户分页查询
     *
     * @param queryUserVO
     * @return
     */
    PageResult<UserBO> pageUser(QueryUserVO queryUserVO);

    /**
     * 根据用户名查询权限编号
     *
     * @param username
     * @return Set<String>
     */
    Set<String> findPermissionCodesByUsername(String username);

    /**
     * 更新最后登录时间
     *
     * @param id
     */
    void updateLastLoginDate(Long id);

}
