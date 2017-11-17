package com.springboot.service.impl;

import com.springboot.mapper.UserMapper;
import com.springboot.model.User;
import com.springboot.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaohong on 2017/11/15.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.findAll();
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findOne(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    @Transactional
    public void edit(User user) {
        userMapper.save(user);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
}
