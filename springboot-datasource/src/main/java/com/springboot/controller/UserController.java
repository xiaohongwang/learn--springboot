package com.springboot.controller;

import com.springboot.model.SysUser;
import com.springboot.service.UserService;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/13.
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/findUserById")
    public SysUser findUserById(){
        return userService.findUserById(1);
    }

}
