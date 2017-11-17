package com.springboot.controller;

import com.springboot.model.SysUser;
import com.springboot.service.SysUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/14.
 */
@RestController
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/findUserById")
    public SysUser findUserById(){
        return  sysUserService.findUserById(1);
    }
}
