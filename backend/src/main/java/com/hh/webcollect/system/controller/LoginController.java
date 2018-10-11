package com.hh.webcollect.system.controller;

import com.hh.webcollect.common.Constant;
import com.hh.webcollect.common.controller.BaseController;
import com.hh.webcollect.common.enums.error.system.SystemErrorCode;
import com.hh.webcollect.common.exception.WcException;
import com.hh.webcollect.common.model.Result;
import com.hh.webcollect.system.model.bo.UserBO;
import com.hh.webcollect.system.model.vo.LoginVO;
import com.hh.webcollect.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@RestController
@RequestMapping
@Api("登录相关的api")
public class LoginController extends BaseController {

    @SuppressWarnings("all")
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private UserService userService;

    @ApiIgnore
    @GetMapping("/login")
    public Result login() {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return Result.err("请先登录！");
    }

    @ApiIgnore
    @GetMapping("/forbidden")
    public Result forbidden() {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        return Result.err("权限不足，请联系管理员！");
    }

    @PostMapping("/doLogin")
    @ApiOperation(value = "登录", notes = "执行登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    public Result<UserBO> doLogin(@Valid LoginVO loginVO) {
        UserBO userBO;
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(loginVO.getUsername(), loginVO.getPassword());
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            userBO = (UserBO) subject.getPrincipal();
            subject.getSession(true).setAttribute(Constant.LOGINUSER, userBO);
            //登录成功后更新最后登录时间
            userService.updateLastLoginDate(userBO.getId());
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
