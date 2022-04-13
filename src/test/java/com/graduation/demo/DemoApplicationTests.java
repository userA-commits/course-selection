package com.graduation.demo;

import com.graduation.demo.entity.*;
import com.graduation.demo.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    TeachCourseService teachCourseService;
    @Test
    void test(){
        System.out.println(teachCourseService.getTeachCourseVo());
    }

}
