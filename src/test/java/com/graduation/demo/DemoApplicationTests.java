package com.graduation.demo;

import com.graduation.demo.entity.Student;
import com.graduation.demo.service.AdminService;
import com.graduation.demo.service.CoursePlanService;
import com.graduation.demo.service.RoleService;
import com.graduation.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    CoursePlanService coursePlanService;
    @Autowired
    StudentService studentService;
    @Test
    void test(){
        Student student = studentService.getById("1");
        student.setDeptNo("0");
        student.setMajorNo("0");
        student.setGrade("0");
        System.out.println(coursePlanService.getMajorWithCourseForStu(student));
    }

}
