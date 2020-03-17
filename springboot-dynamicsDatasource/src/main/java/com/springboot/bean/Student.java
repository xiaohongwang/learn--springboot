package com.springboot.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @Description: 学生信息
 * @Author: wangxh
 * @Date: 2019-02-28 17:44
 */
public class Student {
    @Excel(name = "学生姓名")
    private String name;
    @Excel(name = "年龄")
    private int age;

    @Excel(name = "性别", replace = {"男_1", "女_2"}, suffix = "生")
    private String sex;

    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
