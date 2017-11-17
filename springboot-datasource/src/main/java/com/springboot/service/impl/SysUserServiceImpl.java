package com.springboot.service.impl;

import com.springboot.mapper.SysUserMapper;
import com.springboot.model.SysUser;
import com.springboot.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/13.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Override
    public void findUserById(Integer id) {
       SysUser user =  sysUserMapper.selectByPrimaryKey(1);
        System.out.println(user.toString());
    }
}
