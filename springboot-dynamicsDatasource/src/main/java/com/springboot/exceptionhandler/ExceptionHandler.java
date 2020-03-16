package com.springboot.exceptionhandler;

import com.springboot.bean.ResponseBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: controller异常处理
 * @Author: wangxiaohong
 * @Date: 14:41 2019-10-23
 */
@ControllerAdvice(annotations = {Controller.class, RestController.class})
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseBean handlerException(Exception e){
        System.out.println(e);

        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode("1");
        responseBean.setMessage("error");

        return responseBean;
    }
}
