package com.hh.webcollect.system.service;

import com.hh.webcollect.system.model.bo.UserBO;
import com.hh.webcollect.system.model.vo.LoginVO;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
public interface LoginService {

    /**
     * 登录
     *
     * @param loginVO
     * @return
     */
    UserBO login(LoginVO loginVO);
}
