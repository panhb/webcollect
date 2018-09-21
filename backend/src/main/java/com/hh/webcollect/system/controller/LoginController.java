package com.hh.webcollect.system.controller;

import com.hh.webcollect.common.controller.BaseController;
import com.hh.webcollect.common.model.Result;
import com.hh.webcollect.system.model.bo.UserBO;
import com.hh.webcollect.system.model.vo.LoginVO;
import com.hh.webcollect.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result<UserBO> login(@Valid LoginVO loginVO) {
        return Result.succ(loginService.login(loginVO));
    }

}
