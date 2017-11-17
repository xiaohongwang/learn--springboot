package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaohong on 2017/11/15.
 */
@RestController
@RequestMapping("/test")
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello Spring Boot!!";
    }

}
