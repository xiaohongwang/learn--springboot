package com.springboot.model;

public class SysUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.user_name
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.user_age
     *
     * @mbggenerated
     */
    private String userAge;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.id
     *
     * @return the value of sys_user.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.id
     *
     * @param id the value for sys_user.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.user_name
     *
     * @return the value of sys_user.user_name
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.user_name
     *
     * @param userName the value for sys_user.user_name
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.user_age
     *
     * @return the value of sys_user.user_age
     *
     * @mbggenerated
     */
    public String getUserAge() {
        return userAge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.user_age
     *
     * @param userAge the value for sys_user.user_age
     *
     * @mbggenerated
     */
    public void setUserAge(String userAge) {
        this.userAge = userAge == null ? null : userAge.trim();
    }

    @Override
    public String toString() {
        return "Id:" + id + " 姓名：" + userName + " 年龄：" + userAge;
    }
}