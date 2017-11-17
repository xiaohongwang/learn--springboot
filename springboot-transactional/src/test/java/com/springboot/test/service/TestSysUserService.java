package com.springboot.test.service;

import com.springboot.model.SysUser;
import com.springboot.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSysUserService {
    @Resource
    private SysUserService sysUserService;

    @Test
    public void test(){
        System.out.println(sysUserService.findUserById(1).toString());
    }

    @Test
    public void test2(){
        SysUser sysUser = new SysUser();
        sysUser.setId(7);
        sysUser.setUserName("小爽");
        sysUser.setUserAge("18");
        sysUserService.insertUser(sysUser);
    }

    @Test
    public void test3(){
        SysUser sysUser = new SysUser();
        sysUser.setId(2);
        sysUser.setUserName("小爽");
        sysUser.setUserAge("12");
        sysUserService.updateUser(sysUser);
    }
}
