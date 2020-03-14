package com.hyit.jd.cinema.advice;

import com.hyit.jd.cinema.util.ResultMsg;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class MyExceptionHandler {
    @Autowired
    private ResultMsg resultMsg;

    @Autowired
    public void  ExceptionController(ResultMsg resultMsg) {
        this.resultMsg = resultMsg;
    }

    // 捕捉 CustomRealm 抛出的异常
    @ExceptionHandler(AccountException.class)
    public ResultMsg handleShiroException(Exception ex) {
        return resultMsg.fail(ex.getMessage());
    }
    @ExceptionHandler(ShiroException.class)
    public ResultMsg handle401() {
        return resultMsg.fail("您没有权限访问！");
    }
    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    public ResultMsg globalException(HttpServletRequest request, Throwable ex) {
        return resultMsg.fail("访问出错，无法访问: " + ex.getMessage());

    }
}
