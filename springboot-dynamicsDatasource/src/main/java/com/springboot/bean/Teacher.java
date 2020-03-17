package com.springboot.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.util.List;

/**
 * @Description: 教师
 * @Author: wangxh
 * @Date: 2019-02-28 17:39
 */
@ExcelTarget(value = "major")
public class Teacher {
    @Excel(name = "主讲教师编号_major,代课教师编号_absent", needMerge = true, orderNum = "1")
    private String number;
    @Excel(name = "姓名", needMerge = true)
    private String name;
    @ExcelCollection(name = "教授课程", orderNum = "2")
    private List<Course> courses;

    public Teacher(String number, String name, List<Course> courses) {
        this.number = number;
        this.name = name;
        this.courses = courses;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
