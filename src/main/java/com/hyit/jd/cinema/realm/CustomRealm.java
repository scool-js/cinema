package com.hyit.jd.cinema.realm;

import com.hyit.jd.cinema.mapper.RoleMapper;
import com.hyit.jd.cinema.mapper.UserMapper;
import com.hyit.jd.cinema.model.Role;
import com.hyit.jd.cinema.model.RoleExample;
import com.hyit.jd.cinema.model.User;
import com.hyit.jd.cinema.model.UserExample;
import com.hyit.jd.cinema.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————权限认证————");
        String username = JWTUtil.getUsername(principalCollection.toString());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        Long roleId = users.get(0).getRoleId();
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andIdEqualTo(roleId);
        List<Role> roles = roleMapper.selectByExample(roleExample);
        String role = roles.get(0).getRole();
        String permission = roles.get(0).getPermission();
        Set<String> set = new HashSet<>();
        Set<String> permissionSet = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        set.add(role);
        permissionSet.add(permission);
        //设置该用户拥有的角色
        info.setRoles(set);
        info.setStringPermissions(permissionSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————");

        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null || !JWTUtil.verify(token, username)) {
            throw new AuthenticationException("token认证失败！");
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        String password = users.get(0).getPassword();
        if (null == password) {
            throw new AccountException("用户名不正确");
        }
        Boolean ban = users.get(0).getBan();
        if(ban){
            throw new AccountException("您已被封号");
        }
        return new SimpleAuthenticationInfo(token, token, "MyRealm");
    }
}
