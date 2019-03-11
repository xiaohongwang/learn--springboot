package com.springboot.controller;

import com.springboot.aspect.HandlerDataSourceAop;
import com.springboot.model.SysUser;
import com.springboot.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: wangxh
 * @Date: 2019-03-08 14:49
 */
@Controller
@RequestMapping("/test/")
public class TestController {

    @Resource
    private HandlerDataSourceAop handlerDataSourceAop;

    @Resource
    private SysUserService sysUserService;

    @RequestMapping("changeDataSource")
    @ResponseBody
    public SysUser changeDataSource(){
        return sysUserService.findUserById(4);
    }
}
