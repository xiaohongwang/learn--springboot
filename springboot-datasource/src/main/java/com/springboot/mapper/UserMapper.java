package com.springboot.mapper;

import com.springboot.model.SysUser;

/**
 * Created by xiaohong on 2017/11/13.
 */

public interface UserMapper {
    SysUser findUserById(Integer id);
}
