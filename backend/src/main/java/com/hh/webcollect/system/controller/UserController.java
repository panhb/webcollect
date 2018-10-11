package com.hh.webcollect.system.controller;

import com.hh.webcollect.common.controller.BaseController;
import com.hh.webcollect.common.model.PageResult;
import com.hh.webcollect.common.model.Result;
import com.hh.webcollect.system.model.bo.UserBO;
import com.hh.webcollect.system.model.vo.QueryUserVO;
import com.hh.webcollect.system.model.vo.SaveUserVO;
import com.hh.webcollect.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@RestController
@RequestMapping("/user")
@Api("用户相关的api")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    @ApiOperation(value = "查询用户信息", notes = "根据用户id查询用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", paramType = "path", required = true, dataType = "Long", example = "1")
    public Result<UserBO> findById(@PathVariable Long id) {
        UserBO userBO = userService.findById(id, UserBO.class);
        if (userBO == null) {
            return Result.err("用户不存在");
        }
        return Result.succ(userBO);
    }

    @PostMapping
    @ApiOperation(value = "新增用户", notes = "新增用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "nickname", value = "用户昵称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "remark", value = "备注", dataType = "String")
    })
    public Result<UserBO> save(@Valid SaveUserVO userVO) {
        UserBO userBO = userService.saveUser(userVO);
        return Result.succ(userBO);
    }

    @GetMapping
    @ApiOperation(value = "用户列表", notes = "条件分页获取用户列表")
    public Result<PageResult<UserBO>> pageUser(@Valid QueryUserVO queryUserVO) {
        PageResult<UserBO> userBOPage = userService.pageUser(queryUserVO);
        return Result.succ(userBOPage);
    }

}
