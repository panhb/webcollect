package com.hh.webcollect.common.shiro;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.hh.webcollect.common.Constant;
import com.hh.webcollect.common.enums.StatusEnum;
import com.hh.webcollect.system.model.bo.UserBO;
import com.hh.webcollect.system.service.UserRoleService;
import com.hh.webcollect.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @author hongbo.pan
 * @date 2018/9/21
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("---------------- 执行 shiro 权限获取 ---------------------");
        Object principal = principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (principal instanceof UserBO) {
            UserBO userBO = (UserBO) principal;
            Set<String> roles = userRoleService.findRoleCodesByUsername(userBO.getUsername());
            authorizationInfo.addRoles(roles);

            Set<String> permissions = userService.findPermissionCodesByUsername(userBO.getUsername());
            authorizationInfo.addStringPermissions(permissions);
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("---------------- 执行 shiro 凭证认证 ----------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        UserBO userBO = userService.findByUsername(username);
        if (userBO == null) {
            throw new UnknownAccountException();
        }
        if (StatusEnum.D.getCode().equals(userBO.getStatus())) {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userBO,
                userBO.getPassword(),
                ByteSource.Util.bytes(Constant.PASSWORD_SALT),
                getName()
        );
        return authenticationInfo;
    }
}
