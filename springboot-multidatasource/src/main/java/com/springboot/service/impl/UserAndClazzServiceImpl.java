package com.springboot.service.impl;

import com.springboot.mapper.ClazzMapper;
import com.springboot.mapper.SysUserMapper;
import com.springboot.model.Clazz;
import com.springboot.model.SysUser;
import com.springboot.service.UserAndClazzService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/14.
 */
@Service
public class UserAndClazzServiceImpl implements UserAndClazzService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private ClazzMapper clazzMapper;

    @Override
    @Transactional
    public void insertValue() {
        SysUser sysUser = new SysUser();
        sysUser.setId(12);
        sysUser.setUserName("小爽");
        sysUser.setUserAge("21");
        sysUserMapper.insert(sysUser);

        Clazz clazz = new Clazz();
        clazz.setId(1);
        clazz.setClazzName("外语班");
        clazz.setClazzAge("6");
        clazzMapper.insert(clazz);
    }

    @Override
    public void updataValue() {

    }
}
