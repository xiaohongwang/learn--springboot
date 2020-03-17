package com.springboot.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.springboot.bean.Course;
import com.springboot.bean.Student;
import com.springboot.bean.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 教师 -- 课程 -- 学生信息导出  @Excel(needMerge = true)使用
 * @Author: wangxh
 * @Date: 2019-02-28 17:53
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @RequestMapping("download/list")
    public String downloadList(ModelMap map){
        List<Teacher> teachers = getList();

        ExportParams params = new ExportParams("教师 -- 课程 -- 学生关系导出","first");
        map.put(NormalExcelConstants.DATA_LIST, teachers);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "Teacher - curriculum - student relations");
        map.put(NormalExcelConstants.CLASS, Teacher.class);
        return NormalExcelConstants.EASYPOI_EXCEL_VIEW;
    }
    private List<Teacher> getList(){
        List<Teacher> teachers = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();


        Student student = new Student("小明", 20, "1");
        students.add(student);

        student = new Student("小红", 18, "2");
        students.add(student);

        Course course = new Course("物理","理科", students);
        courses.add(course);

        course = new Course("政治","文科", students);
        courses.add(course);

        Teacher teacher = new Teacher("01", "江老师", courses);
        teachers.add(teacher);

        teacher = new Teacher("02", "王老师", courses);
        teachers.add(teacher);

        return teachers;

    }

}
