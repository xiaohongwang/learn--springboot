package com.springboot.bean;

/**
 * @Description: 响应码
 * @Author: wangxh
 * @Date: 2019-04-11 18:09
 */
public enum ResponseEnum {
    SUCCESS("000","请求成功");


    String code;
    String message;

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }}

