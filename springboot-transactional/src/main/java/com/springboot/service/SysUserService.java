package com.springboot.service;

import com.springboot.model.SysUser;

/**
 * Created by xiaohong on 2017/11/14.
 */
public interface SysUserService {
    SysUser findUserById(Integer id);

    void insertUser(SysUser sysUser);

     void updateUser(SysUser sysUser);
}
