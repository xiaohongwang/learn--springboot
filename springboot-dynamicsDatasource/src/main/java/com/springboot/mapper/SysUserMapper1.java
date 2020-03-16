package com.springboot.mapper;

import com.springboot.bean.DeptUser;
import com.springboot.model.SysUser;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface SysUserMapper1 {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated
     */
    int insert(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated
     */
    int insertSelective(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated
     */
    SysUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysUser record);

    /**
     * 查询所有用户信息
     * @return
     */
    List<SysUser> selectAll();

    /**
    * @Title:selectSysUser
    * @Description: 测试rowbound查询
    * @author: wangxiaohong
    * @param: [rowBounds]
    * @return java.util.List<com.springboot.model.SysUser>
    * @date: 10:35 2019-12-13
    * @version v1.0
    */
    List<SysUser> selectSysUser(RowBounds rowBounds);

    List<DeptUser> findDeptUser();
}