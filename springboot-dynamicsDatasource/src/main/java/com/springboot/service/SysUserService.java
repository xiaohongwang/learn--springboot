package com.springboot.service;

import com.springboot.bean.DeptUser;
import com.springboot.model.SysUser;
import org.apache.ibatis.session.RowBounds;

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


    /**
    * @Title:findUserList
    * @Description: 测试mybayis分页 rowBound
    * @author: wangxiaohong
    * @param: [rowBounds]
    * @return java.util.List<com.springboot.model.SysUser>
    * @date: 10:34 2019-12-13
    * @version v1.0
    */
    List<SysUser> findUserList(RowBounds rowBounds);

    List<DeptUser> findDeptUser();

    /**
    * @Title:insertData
    * @Description: 插入数据信息
    * @author: wangxiaohong
    * @param: []
    * @return void
    * @date: 11:05 2019-12-16
    * @version v1.0
    */
    void lazyLoad();
}
