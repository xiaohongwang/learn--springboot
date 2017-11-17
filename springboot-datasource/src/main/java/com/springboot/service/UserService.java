package com.springboot.service;

import com.springboot.model.SysUser;

/**
 * Created by xiaohong on 2017/11/13.
 */
public interface UserService {
     SysUser findUserById(Integer id);
}
