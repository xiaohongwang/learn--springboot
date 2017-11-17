package com.springboot.test.mapper;

import com.springboot.mapper.SysUserMapper;
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
public class TestSysUserMapper {
    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    public void findUserById(){
       SysUser user = sysUserMapper.selectByPrimaryKey(1);
        System.out.println(user.toString());
    }
}
