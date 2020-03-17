package com.springboot.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;

import java.util.List;

/**
 * @Description: 课程
 * @Author: wangxh
 * @Date: 2019-02-28 17:44
 */
public class Course {

    @Excel(name = "课程名", needMerge = true)
    private String name;
    @Excel(name = "课程性质", needMerge = true)
    private String character;

    @ExcelCollection(name = "在修学生")
    private List<Student> students;

    public Course(String name, String character, List<Student> students) {
        this.name = name;
        this.character = character;
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
