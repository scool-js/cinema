package com.hyit.jd.cinema.controller;

import com.hyit.jd.cinema.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    private ResultMsg resultMsg;

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public ResultMsg getMessage() {
        return resultMsg.success("您拥有用户权限，可以获得该接口的信息！");
    }
}
