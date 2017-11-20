package com.springboot.service;

import com.springboot.model.SysUser;

/**
 * Created by xiaohong on 2017/11/20.
 */
public interface SysUserService {

    SysUser findUserById(Integer userId);
}
