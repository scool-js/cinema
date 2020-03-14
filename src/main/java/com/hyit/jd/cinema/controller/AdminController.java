package com.hyit.jd.cinema.controller;

import com.hyit.jd.cinema.util.ResultMsg;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ResultMsg resultMap;

    @RequiresRoles("admin")
    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public ResultMsg getMessage() {
        return resultMap.success("您拥有管理员权限，可以获得该接口的信息！");
    }
}