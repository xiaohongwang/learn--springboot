package com.springboot.test.service;

import com.springboot.service.SysUserService;
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
public class TestSysUserService {
    @Resource
    private SysUserService sysUserService;
    @Test
    public void test(){
        sysUserService.findUserById(1);
    }
}
