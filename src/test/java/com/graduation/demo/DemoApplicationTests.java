package com.graduation.demo;

import com.graduation.demo.entity.Student;
import com.graduation.demo.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    CourseArrangeService courseArrangeService;
    @Test
    void test(){
        System.out.println(courseArrangeService.getCourseArrangeVoForAdm());
    }

}
