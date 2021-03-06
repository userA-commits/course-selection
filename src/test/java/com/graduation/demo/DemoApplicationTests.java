package com.graduation.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.demo.entity.base.Clazz;
import com.graduation.demo.entity.business.CoursePlan;
import com.graduation.demo.entity.system.RoleMenu;
import com.graduation.demo.mapper.CoursePlanMapper;
import com.graduation.demo.service.*;
import com.graduation.demo.vo.business.CoursePlanVo;
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
        System.out.println(courseTableService.getCourseTable());

    }

}
