package com.hyit.jd.cinema.controller;

import com.hyit.jd.cinema.mapper.RoleMapper;
import com.hyit.jd.cinema.mapper.UserMapper;
import com.hyit.jd.cinema.model.Role;
import com.hyit.jd.cinema.model.RoleExample;
import com.hyit.jd.cinema.model.User;
import com.hyit.jd.cinema.model.UserExample;
import com.hyit.jd.cinema.util.JWTUtil;
import com.hyit.jd.cinema.util.ResultMsg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
        @Autowired
        private ResultMsg resultMap;
        @Autowired
        private UserMapper userMapper;
        @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
        public ResultMsg notLogin() {
            return resultMap.success("您尚未登陆！");
        }

        @RequestMapping(value = "/notRole", method = RequestMethod.GET)
        public ResultMsg notRole() {
            return resultMap.success("您没有权限！");
        }

        @RequestMapping(value = "/logout", method = RequestMethod.GET)
        public ResultMsg logout() {
            Subject subject = SecurityUtils.getSubject();
            //注销
            subject.logout();
            return resultMap.success("成功注销！");
        }

        /**
         * 登陆
         */
        @RequestMapping(value = "/login", method = RequestMethod.POST)
        public ResultMsg login(@RequestBody User user) {
            //根据权限，指定返回数据
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUsernameEqualTo(user.getUsername());
            List<User> users = userMapper.selectByExample(userExample);
            String password = users.get(0).getPassword();
            if (password == null) {
                return resultMap.fail("用户名错误");
            } else if (!password.equals(user.getPassword())) {
                return resultMap.fail("密码错误");
            } else {
                return resultMap.success().add("token",JWTUtil.createToken(user.getUsername()));
            }
        }

}
