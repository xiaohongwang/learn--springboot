package com.springboot.bean;

import com.springboot.model.SysUser;

import java.util.List;

/**
 * @Description:部门用户表
 * @Author: wangxiaohong
 * @Date: 11:36 2019-12-13
 */
public class DeptUser {

    private String deptId;
    private List<SysUser>  sysUsers;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }


    public List<SysUser> getSysUsers() {
        return sysUsers;
    }

    public void setSysUsers(List<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
    }
}
