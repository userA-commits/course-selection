package com.graduation.demo;

import com.graduation.demo.entity.*;
import com.graduation.demo.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    TeachCourseService teachCourseService;
    @Test
    void test(){
//        TeachCourse teachCourse = new TeachCourse();
//        teachCourse.setTeacherNo("teacher2");
//        teachCourse.setClazzNo("CS181");
//        teachCourse.setCourseNo("MS0001");
//        teachCourse.setTeachCourseNo("MS0001.teacher2.CS181");
//        teachCourse.setState(0);
//        //存储时，存入对应的学生选课信息
//        teachCourseService.saveRequired(teachCourse);


        List<String> ids = new ArrayList<>();
        ids.add("2");
        teachCourseService.removeRequired(ids);
    }

}
