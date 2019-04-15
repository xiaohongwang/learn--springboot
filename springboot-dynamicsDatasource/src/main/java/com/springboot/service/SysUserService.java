package com.springboot.service;

import com.springboot.model.SysUser;

import java.util.List;

/**
 * Created by xiaohong on 2017/11/20.
 */
public interface SysUserService {

    /**
     * 根据人员id查询信息  测试动态数据源切换
     * @param userId
     * @return
     */
    SysUser findUserById(Integer userId);

    /**
     * 查询用户信息  测试分页插件pageHelper
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<SysUser> findUserList(Integer currentPage, Integer pageSize);
}
