package com.graduation.demo;

import com.graduation.demo.entity.Menu;
import com.graduation.demo.entity.Teacher;
import com.graduation.demo.mapper.TeacherMapper;
import com.graduation.demo.po.TeacherWithCourse;
import com.graduation.demo.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    TeacherMapper teacherMapper;
    @Test
    void contextLoads() {
        List<TeacherWithCourse> teacherWithCourses = teacherMapper.getTeacherWithCourse("teacher1");

        for(TeacherWithCourse teacherWithCourse : teacherWithCourses){
            System.out.println(teacherWithCourse);
        }
    }

}
