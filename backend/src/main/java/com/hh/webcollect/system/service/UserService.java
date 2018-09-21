package com.hh.webcollect.system.service;

import com.hh.webcollect.common.model.PageResult;
import com.hh.webcollect.common.service.BaseService;
import com.hh.webcollect.system.model.bo.UserBO;
import com.hh.webcollect.system.model.entity.User;
import com.hh.webcollect.system.model.vo.AddUserVO;
import com.hh.webcollect.system.model.vo.QueryUserVO;

import java.util.Set;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
public interface UserService extends BaseService<User, UserBO> {

    /**
     * 新增用户
     *
     * @param addUserVO
     * @return
     */
    UserBO addUser(AddUserVO addUserVO);

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return UserBO
     */
    UserBO findByUsername(String username);

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

}
