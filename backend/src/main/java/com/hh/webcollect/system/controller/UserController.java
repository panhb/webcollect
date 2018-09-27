package com.hh.webcollect.system.controller;

import com.hh.webcollect.common.controller.BaseController;
import com.hh.webcollect.common.model.PageResult;
import com.hh.webcollect.common.model.Result;
import com.hh.webcollect.system.model.bo.UserBO;
import com.hh.webcollect.system.model.vo.QueryUserVO;
import com.hh.webcollect.system.model.vo.SaveUserVO;
import com.hh.webcollect.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Result<UserBO> findById(@PathVariable Long id) {
        return Result.succ(userService.findById(id, UserBO.class));
    }

    @PostMapping
    public Result<UserBO> save(@Valid SaveUserVO userVO) {
        UserBO userBO = userService.saveUser(userVO);
        return Result.succ(userBO);
    }

    @GetMapping
    public Result<PageResult<UserBO>> pageUser(@Valid QueryUserVO queryUserVO) {
        PageResult<UserBO> userBOPage = userService.pageUser(queryUserVO);
        return Result.succ(userBOPage);
    }

}
