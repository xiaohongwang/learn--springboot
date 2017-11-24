package com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaohong on 2017/11/13.
 */
@SpringBootApplication
@RestController
public class ApplicationStarter {
    public static void main(String[] args){
        SpringApplication.run(ApplicationStarter.class, args);
    }

    @RequestMapping("/test")
    public String test(){
        return "Hello Spring Boot!!";
    }
}
