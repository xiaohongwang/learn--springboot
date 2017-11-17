package com.springboot;

import org.apache.ibatis.annotations.Results;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/13.
 */
@SpringBootApplication
@RestController
public class SpringBootStarter {

    public static void main(String[] args){
        SpringApplication.run(SpringBootStarter.class,args);
    }

    @RequestMapping("/test")
    public String test(){
        return "Hello Spring Boot!!";
    }
}
