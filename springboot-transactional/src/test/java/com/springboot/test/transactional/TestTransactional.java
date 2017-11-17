package com.springboot.test.transactional;

import com.springboot.mapper.SysUserMapper;
import com.springboot.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTransactional {
    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    @Transactional
    public void test(){
        SysUser sysUser = new SysUser();
        sysUser.setId(7);
        sysUser.setUserName("小爽");
        sysUser.setUserAge("18");
        sysUserMapper.insert(sysUser);

        sysUser.setId(1);
        sysUserMapper.insert(sysUser);
    }

    @Test
    @Transactional
    @Rollback
    public void test2(){
        SysUser sysUser = new SysUser();
        sysUser.setId(6);
        sysUser.setUserName("小爽");
        sysUser.setUserAge("18");
        sysUserMapper.insert(sysUser);
    }
}
