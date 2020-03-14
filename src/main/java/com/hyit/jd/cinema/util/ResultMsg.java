package com.hyit.jd.cinema.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResultMsg {
    //状态码 100成功 200-失败
    private int code;

    private String msg;

    private Map<String,Object> extend = new HashMap<String,Object>();

    public static ResultMsg success(){
        ResultMsg reuslt = new ResultMsg();
        reuslt.setCode(100);
        reuslt.setMsg("处理成功");
        return reuslt;
    }
    public static ResultMsg success(String message){
        ResultMsg reuslt = new ResultMsg();
        reuslt.setCode(100);
        reuslt.setMsg(message);
        return reuslt;
    }
    public static ResultMsg fail(){
        ResultMsg reuslt = new ResultMsg();
        reuslt.setCode(200);
        reuslt.setMsg("处理失败");
        return reuslt;
    }
    public static ResultMsg fail(String msg){
        ResultMsg reuslt = new ResultMsg();
        reuslt.setCode(200);
        reuslt.setMsg(msg);
        return reuslt;
    }

    public ResultMsg add(String key,Object value){
        this.getExtend().put(key, value);
        return this;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
