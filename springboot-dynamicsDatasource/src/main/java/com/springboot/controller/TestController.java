package com.springboot.controller;

import com.springboot.aspect.HandlerDataSourceAop;
import com.springboot.bean.ResponseBean;
import com.springboot.bean.ResponseEnum;
import com.springboot.model.SysUser;
import com.springboot.service.SysUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: wangxh
 * @Date: 2019-03-08 14:49
 */
@RestController
@RequestMapping("/test/")
public class TestController {

    @Resource
    private HandlerDataSourceAop handlerDataSourceAop;

    @Resource
    private SysUserService sysUserService;

    @RequestMapping("changeDataSource")
    public SysUser changeDataSource(){
        return sysUserService.findUserById(3);
    }

    @RequestMapping("testPageHelper")
    public ResponseBean testPageHelper(Integer currentPage, Integer pageSize){
        List<SysUser> userList = sysUserService.findUserList(currentPage, pageSize);
        ResponseBean responseBean = new ResponseBean(ResponseEnum.SUCCESS.getCode(),
                ResponseEnum.SUCCESS.getMessage());
        responseBean.setResult(userList);
        return responseBean;
    }
}
