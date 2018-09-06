package com.hh.webcollect.system.service.impl;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.hh.webcollect.common.Constant;
import com.hh.webcollect.common.enums.error.system.SystemErrorCode;
import com.hh.webcollect.common.exception.WcException;
import com.hh.webcollect.system.model.bo.UserBO;
import com.hh.webcollect.system.model.vo.LoginVO;
import com.hh.webcollect.system.service.LoginService;
import com.hh.webcollect.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 *
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Override
    public UserBO login(LoginVO loginVO) {
        UserBO userBO = userService.findByUsername(loginVO.getUsername());
        if (userBO == null) {
            throw new WcException(SystemErrorCode.USER_IS_NOT_EXIST);
        }
        String password = Hashing.sha256().hashString(
                loginVO.getPassword() + Constant.PASSWORD_SALT, Charsets.UTF_8).toString();
        if (!userBO.getPassword().equals(password)) {
            throw new WcException(SystemErrorCode.PASSWORD_ERROR);
        }
        return userBO;
    }
}
