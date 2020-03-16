package com.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.annotations.DynamicSwitchDataSource;
import com.springboot.bean.DeptUser;
import com.springboot.mapper.SysUserMapper;
import com.springboot.mapper.SysUserMapper1;
import com.springboot.model.SysUser;
import com.springboot.service.SysUserService;
import org.apache.ibatis.session.RowBounds;
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

    @Resource
    private SysUserMapper1 sysUserMapper1;

    @Override
    @DynamicSwitchDataSource(dataSource = "datasource1")
    public SysUser findUserById(Integer userId) {
        sysUserMapper1.selectByPrimaryKey(userId);

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



    @Override
    public List<SysUser> findUserList(RowBounds rowBounds) {
       return sysUserMapper.selectSysUser(rowBounds);
    }

    @Override
    public List<DeptUser> findDeptUser() {

        PageHelper.startPage(0, 1);
        List<DeptUser> deptUser = sysUserMapper.findDeptUser();
        PageInfo pageInfo = new PageInfo(deptUser);
        // 总数错误
        System.out.println(pageInfo.getTotal());
        return pageInfo.getList();
 //       return deptUser;
    }

    @Override
    public void lazyLoad() {
        PageHelper.startPage(0, 1);
        List<DeptUser> deptUsers = sysUserMapper.findDeptUser();

        deptUsers.stream().forEach(deptUser ->{
             deptUser.getSysUsers().stream().forEach(sysUser -> {
                 System.out.println(sysUser);
             });
        });

        PageInfo pageInfo = new PageInfo(deptUsers);
        // 总数错误
        System.out.println(pageInfo.getTotal());
    }
// SELECT count(0) FROM t_dept_user LEFT JOIN sys_user ON t_dept_user.user_id = sys_user.id

// SELECT dept_id, user_id , sys_user.user_name, sys_user.user_age
//        FROM t_dept_user left join sys_user on t_dept_user.user_id = sys_user.id LIMIT 1

}
