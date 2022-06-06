package com.cscd.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description 用于请求之后返回的json
 */
@Component
public class RespMsg {
    private Integer code;
    private String msg;
    private Object data;
    private LocalDateTime dateTime;

    public RespMsg() {}
    private static DateTimeFormatter dfDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public static RespMsg getInstance(){
        RespMsg respMsg = new RespMsg();
        respMsg.dateTime = LocalDateTime.now();
        return respMsg;
    }

    /**
     *
     * @param executeSuccess 是否执行成功
     * @return
     */
    public static RespMsg getInstance(Boolean executeSuccess){
        if (executeSuccess)
            return getOKInstance();
        else
            return getFailureInstance();
    }

    private RespMsg(String msg) {
        this.msg = msg;
    }

    private RespMsg(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }


    private RespMsg(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static RespMsg getOKInstance(String msg, Object data){
        RespMsg respMsg = getInstance();
        respMsg.code = 200;
        respMsg.msg = msg;
        respMsg.data = data;
        return respMsg;
    }
    public static RespMsg getOKInstance(Object data){
        RespMsg respMsg = getInstance();
        respMsg.code = 200;
        respMsg.msg = "执行成功";
        respMsg.data = data;
        return respMsg;
    }
    public static RespMsg getOKInstance(){
        RespMsg respMsg = getInstance();
        respMsg.code = 200;
        respMsg.msg = "执行成功";
        return respMsg;
    }
    public static RespMsg getFailureInstance(String msg, Object data){
        RespMsg respMsg = getInstance();
        respMsg.code = 400;
        respMsg.msg = msg;
        respMsg.data = data;
        return respMsg;
    }
    public static RespMsg getFailureInstance(String msg){
        RespMsg respMsg = getInstance();
        respMsg.code = 400;
        respMsg.msg = msg;
        return respMsg;
    }
    public static RespMsg getFailureInstance(){
        RespMsg respMsg = getInstance();
        respMsg.code = 400;
        respMsg.msg = "执行失败";
        return respMsg;
    }
    public RespMsg setCode(Integer code){
        this.code = code;
        return this;
    }
    public RespMsg setMsg(String msg){
        this.msg = msg;
        return this;
    }
    public RespMsg setData(Object data){
        this.data = data;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public String getDateTime() {
        return dfDateTime.format(dateTime);
    }
}
