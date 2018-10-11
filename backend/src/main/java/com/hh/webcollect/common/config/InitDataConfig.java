package com.hh.webcollect.common.config;

import com.google.common.collect.Lists;
import com.hh.webcollect.common.Constant;
import com.hh.webcollect.system.model.bo.RoleBO;
import com.hh.webcollect.system.model.bo.UserBO;
import com.hh.webcollect.system.model.bo.UserRoleBO;
import com.hh.webcollect.system.model.vo.SaveRoleVO;
import com.hh.webcollect.system.model.vo.SaveUserRoleVO;
import com.hh.webcollect.system.model.vo.SaveUserVO;
import com.hh.webcollect.system.service.RoleService;
import com.hh.webcollect.system.service.UserRoleService;
import com.hh.webcollect.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author hongbo.pan
 * @date 2018/10/11
 */
@Component
public class InitDataConfig implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public void run(String... args) {
        UserBO userBO = userService.findByUsername(Constant.SUPER_USERNAME);
        if (userBO == null) {
            SaveUserVO saveUserVO = new SaveUserVO();
            saveUserVO.setUsername(Constant.SUPER_USERNAME);
            saveUserVO.setPassword(Constant.SUPER_PASSWORD);
            saveUserVO.setNickname(Constant.SUPER_USERNAME);
            saveUserVO.setRemark("初始化超级管理员");
            userService.saveUser(saveUserVO);
        }

        RoleBO roleBO = roleService.findByCode(Constant.SUPER_ROLE);
        if (roleBO == null) {
            SaveRoleVO saveRoleVO = new SaveRoleVO();
            saveRoleVO.setCode(Constant.SUPER_ROLE);
            saveRoleVO.setName("超级管理员");
            roleService.saveRole(saveRoleVO);
        }

        UserRoleBO userRoleBO = userRoleService.findByUsernameAndRoleCode(Constant.SUPER_USERNAME, Constant.SUPER_ROLE);
        if (userRoleBO == null) {
            SaveUserRoleVO saveUserRoleVO = new SaveUserRoleVO();
            saveUserRoleVO.setRoleCode(Constant.SUPER_ROLE);
            saveUserRoleVO.setUsername(Constant.SUPER_USERNAME);
            userRoleService.saveUserRole(Lists.newArrayList(saveUserRoleVO));
        }
    }
}
