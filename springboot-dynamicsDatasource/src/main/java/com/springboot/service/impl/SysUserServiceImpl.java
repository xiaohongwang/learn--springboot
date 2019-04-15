package com.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.annotations.DynamicSwitchDataSource;
import com.springboot.mapper.SysUserMapper;
import com.springboot.model.SysUser;
import com.springboot.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaohong on 2017/11/20.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    @DynamicSwitchDataSource(dataSource = "datasource2")
    public SysUser findUserById(Integer userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }


    @Override
    @DynamicSwitchDataSource(dataSource = "datasource1")
    public List<SysUser> findUserList(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<SysUser> sysUsers =  sysUserMapper.selectAll();
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUsers);
        return pageInfo.getList();
    }


}
