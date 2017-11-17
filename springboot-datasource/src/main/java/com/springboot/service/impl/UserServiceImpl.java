package com.springboot.service.impl;

import com.springboot.mapper.UserMapper;
import com.springboot.model.SysUser;
import com.springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/13.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public SysUser findUserById(Integer id) {
        return userMapper.findUserById(1);
    }
}
