package com.hyit.jd.cinema.controller;

import com.hyit.jd.cinema.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    private ResultMsg resultMsg;

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public ResultMsg login() {
        return resultMsg.success("欢迎进入，您的身份是游客");
    }

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public ResultMsg submitLogin() {
        return resultMsg.success("您拥有获得该接口的信息的权限！");
    }
}
