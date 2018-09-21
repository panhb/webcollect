package com.hh.webcollect.system.controller;

import com.hh.webcollect.common.controller.BaseController;
import com.hh.webcollect.common.enums.error.system.SystemErrorCode;
import com.hh.webcollect.common.exception.WcException;
import com.hh.webcollect.common.model.Result;
import com.hh.webcollect.system.model.bo.UserBO;
import com.hh.webcollect.system.model.vo.LoginVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@RestController
@RequestMapping
public class LoginController extends BaseController {

    @SuppressWarnings("all")
    @Autowired
    private HttpServletResponse response;

    @GetMapping("/login")
    public Result login() {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return Result.err("请先登录！");
    }

    @GetMapping("/forbidden")
    public Result forbidden() {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        return Result.err("权限不足，请联系管理员！");
    }

    @PostMapping("/doLogin")
    public Result<UserBO> doLogin(@Valid LoginVO loginVO) {
        UserBO userBO;
        try {

            UsernamePasswordToken token = new UsernamePasswordToken(loginVO.getUsername(), loginVO.getPassword());
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            userBO = (UserBO) subject.getPrincipal();
        } catch (UnknownAccountException e) {
            throw new WcException(SystemErrorCode.USER_IS_NOT_EXIST);
        } catch (LockedAccountException e) {
            throw new WcException(SystemErrorCode.USER_IS_LOCKED);
        } catch (IncorrectCredentialsException e) {
            throw new WcException(SystemErrorCode.PASSWORD_ERROR);
        }
        return Result.succ(userBO);
    }

}
