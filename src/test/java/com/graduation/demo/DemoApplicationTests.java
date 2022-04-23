package com.graduation.demo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.demo.entity.business.CoursePlan;
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
    CoursePlanMapper coursePlanMapper;
    @Test
    void test(){
        IPage<CoursePlanVo> page = new Page<CoursePlanVo>(1, 10);
        CoursePlanVo coursePlanVo = new CoursePlanVo();
        coursePlanVo.setDeptNo("S");
        coursePlanMapper.loadAllCoursePlan(page, coursePlanVo);
        System.out.println(page.getRecords().get(0).getCourseName());
    }

}
