package com.example.demo.shiro;

import com.example.demo.entity.Permission;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.UserManagerService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义realm
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    UserManagerService userManagerService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        User user = userManagerService.getUserByUserName(username);
        List<Role> rs = userManagerService.getRoleByUserid(user.getId());
        Set<String> roles = new HashSet<>();
        Set<String> ps = new HashSet<>();
        //获得role和permission
        for (Role role : rs) {
            roles.add(role.getRolename());
            List<Permission> permissions = userManagerService.getPermissionByRoleid(role.getId());
            for (Permission permission : permissions) {
                ps.add(permission.getPermissionname());
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(ps);
        return simpleAuthorizationInfo;
    }

    //验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        User user = userManagerService.getUserByUserName(userName);
        String password = null;
        if (user != null) {
            password = user.getPassword();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, password, "testRealm");
        return authenticationInfo;
    }
}
