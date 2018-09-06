package com.hh.webcollect.system.service.impl;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.hh.webcollect.common.Constant;
import com.hh.webcollect.common.service.BaseServiceImpl;
import com.hh.webcollect.common.util.BeanUtil;
import com.hh.webcollect.system.model.bo.UserBO;
import com.hh.webcollect.system.model.entity.User;
import com.hh.webcollect.system.model.vo.AddUserVO;
import com.hh.webcollect.system.repository.UserRepository;
import com.hh.webcollect.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserBO> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserBO addUser(AddUserVO addUserVO) {
        UserBO userBO = BeanUtil.copyBean(addUserVO, UserBO.class);
        String password = userBO.getPassword();
        password = Hashing.sha256().hashString(
                password + Constant.PASSWORD_SALT, Charsets.UTF_8).toString();
        userBO.setPassword(password);
        User savedUser = save(BeanUtil.copyBean(userBO, User.class));
        return BeanUtil.copyBean(savedUser, UserBO.class);
    }

    @Override
    public UserBO findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return BeanUtil.copyBean(user, UserBO.class);
        }
        return null;
    }
}
