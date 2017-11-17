package com.springboot.service;

import com.springboot.model.User;

import java.util.List;

/**
 * Created by xiaohong on 2017/11/15.
 */
public interface UserService {
     List<User> getUserList();

     User findUserById(Integer id);

     void save(User user);

     void edit(User user);

     void delete(Integer id);

    User findUserByUserName(String userName);
}
