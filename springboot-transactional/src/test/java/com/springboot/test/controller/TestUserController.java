package com.springboot.test.controller;

import com.springboot.controller.SysUserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserController {

    @Resource
    private SysUserController sysUserController;

    @Test
    public void test(){
        System.out.println(sysUserController.findUserById().toString());
    }
}
