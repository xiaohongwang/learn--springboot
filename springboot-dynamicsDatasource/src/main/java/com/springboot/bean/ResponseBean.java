package com.springboot.bean;

/**
 * @Description: 响应信息结构
 * @Author: wangxh
 * @Date: 2019-04-11 18:06
 */
public class ResponseBean<T> {
    private String code;
    private String message;
    private T result;

    public ResponseBean(){}

    public ResponseBean(String code, String message){
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
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
