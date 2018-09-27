package com.hh.webcollect.common.shiro;

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
import org.springframework.context.annotation.Lazy;

import java.util.Set;

/**
 * @author hongbo.pan
 * @date 2018/9/21
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    /**
     * Lazy注解，延迟Realm实现中Service对象的初始化时间，
     * 这样就可以保证Service实际初始化的时候会被BeanPostProcessor拦截，
     * 创建具有事务功能的代理对象
     * 此处解决userService事务失效
     *
     * 破除循环依赖时，也可以通过Lazy注解解决
     *
     * 此处还有二个种解决方式
     * 1.不注入service，通过dao层调用获取数据，没有验证
     * 2.写一个监听器，在spring初始化完成后设置自己的realm就可以了，没有验证
     */
    @Autowired
    @Lazy
    private UserService userService;

    @Autowired
    @Lazy
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
