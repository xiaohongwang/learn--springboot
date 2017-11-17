package com.springboot.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaohong on 2017/11/15.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return "Hello Spring Boot!!";
    }
}
