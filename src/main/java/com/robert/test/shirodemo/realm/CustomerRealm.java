package com.robert.test.shirodemo.realm;

import com.robert.test.shirodemo.dto.*;
import com.robert.test.shirodemo.util.ApplicationContextUtil;
import com.robert.test.shirodemo.util.CustomerByteSource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 自定义realm
 */
public class CustomerRealm extends AuthorizingRealm {
    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取主身份信息
        String principal = (String) principals.getPrimaryPrincipal();
        // 根据主身份信息获取角色信息
        UserService userService = (UserService) ApplicationContextUtil.getBean("userService");
        User user = userService.findUserByUserName(principal);

        RoleService roleService = (RoleService) ApplicationContextUtil.getBean("roleService");
        List<Role> roles = roleService.getRolesByUserId(user.getId());
        if(!CollectionUtils.isEmpty(roles)){
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            roles.forEach(role -> {
                simpleAuthorizationInfo.addRole(role.getName());
                PermissionService permissionService = (PermissionService) ApplicationContextUtil.getBean("permissionService");
                List<Permission> permissions = permissionService.getPermissionsByRoleId(role.getId());
                if(!CollectionUtils.isEmpty(permissions)){
                    permissions.forEach(permission -> {
                        simpleAuthorizationInfo.addStringPermission(permission.getName());
                    });
                }
            });
            return simpleAuthorizationInfo;
        }
        return null;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取当前登录的主题
        String principal = (String) token.getPrincipal();
        // 由于CustomerRealm并没有交由工厂管理，故不能诸如UserService

        //ApplicationContextUtil.printApplicationContext();

        UserService userService = (UserService) ApplicationContextUtil.getBean("userService");
        User user = userService.findUserByUserName(principal);
        if(!ObjectUtils.isEmpty(user)){
            return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), new CustomerByteSource(user.getSalt()),this.getName());
        }
        return null;
    }
}




