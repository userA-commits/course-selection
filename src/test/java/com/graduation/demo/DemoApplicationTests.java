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
    CourseArrangeService courseArrangeService;
    @Test
    void test(){
        CourseArrange courseArrange = new CourseArrange();
        courseArrange.setTeachCourseNo("MS0001.teacher2.CS181");
        courseArrange.setClassroomNo("H4001");
        courseArrange.setWeek(1);
        courseArrange.setPeriod(3);
        System.out.println(courseArrangeService.addWithConflictCheck(courseArrange));
    }

}
