package com.hh.webcollect.system.service;

import com.hh.webcollect.common.service.BaseService;
import com.hh.webcollect.system.model.bo.UserBO;
import com.hh.webcollect.system.model.entity.User;
import com.hh.webcollect.system.model.vo.AddUserVO;

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

}
