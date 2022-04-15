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
    CourseTableService courseTableService;
    @Test
    void test(){
        Teacher teacher = new Teacher();
        teacher.setTeacherNo("teacher2");
        System.out.println(courseTableService.getCourseTableForTea(teacher));
    }

}
