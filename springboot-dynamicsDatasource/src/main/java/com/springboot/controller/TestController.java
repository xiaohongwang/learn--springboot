package com.springboot.controller;

import com.springboot.annotations.LogAnno;
import com.springboot.aspect.HandlerDataSourceAop;
import com.springboot.bean.DeptUser;
import com.springboot.bean.ResponseBean;
import com.springboot.bean.ResponseEnum;
import com.springboot.model.SysUser;
import com.springboot.service.SysUserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @LogAnno(operateModule = "测试多数元切换",
            operateContent = "changeDataSource", operateMethod = "changeDataSource")
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

    @RequestMapping(path = "test", headers = "Accept=application/json")
    public ResponseBean test(HttpServletRequest request, HttpServletResponse response){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode("123");
        return responseBean;
    }


    @RequestMapping("/testRowBound")
    public ResponseBean testRowBound(){
        RowBounds rowBounds = new RowBounds(0, 3);

       List<SysUser> sysUsers =
               sysUserService.findUserList(rowBounds);

        ResponseBean responseBean = new ResponseBean(ResponseEnum.SUCCESS.getCode(),
                ResponseEnum.SUCCESS.getMessage());
        responseBean.setResult(sysUsers);
        return responseBean;
    }

    // 一对多数据分页
    @RequestMapping("/testLimit")
    public ResponseBean testLimit(){
        List<DeptUser> sysUsers =
                sysUserService.findDeptUser();

        ResponseBean responseBean = new ResponseBean(ResponseEnum.SUCCESS.getCode(),
                ResponseEnum.SUCCESS.getMessage());
        responseBean.setResult(sysUsers);
        return responseBean;
    }


    @RequestMapping("/testPageHelper2")
    public ResponseBean testPageHelper(){
        List<DeptUser> sysUsers =
                sysUserService.findDeptUser();

        ResponseBean responseBean = new ResponseBean(ResponseEnum.SUCCESS.getCode(),
                ResponseEnum.SUCCESS.getMessage());
        responseBean.setResult(sysUsers);
        return responseBean;
    }


    /**
    * @Title:insertData
    * @Description: 插入数据信息
    * @author: wangxiaohong
    * @param: []
    * @return com.springboot.bean.ResponseBean
    * @date: 11:04 2019-12-16
    * @version v1.0
    */
    @RequestMapping("/lazyLoad")
    public ResponseBean lazyLoad(){
        sysUserService.lazyLoad();
        ResponseBean responseBean = new ResponseBean(ResponseEnum.SUCCESS.getCode(),
                ResponseEnum.SUCCESS.getMessage());
        return responseBean;
    }


}
