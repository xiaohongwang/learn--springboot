package com.springboot.test.controller;

import com.springboot.controller.UserController;
import com.springboot.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserController {
    @Resource
    private UserController userController;

    @Test
    public void test(){
        SysUser sysUser = userController.findUserById();
        System.out.println(sysUser.toString());
    }
}
