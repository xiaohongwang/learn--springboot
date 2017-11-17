package com.springboot.controller;

import com.springboot.service.UserAndClazzService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/14.
 */
@RestController
public class UserAndClazzController {
    @Resource
    private UserAndClazzService userAndClazzService;

    @RequestMapping("/test/userAndClazz")
    public String testUserAndClazz(){
        userAndClazzService.insertValue();
        return "success";
    }
}
