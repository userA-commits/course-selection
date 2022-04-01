package com.graduation.demo.controller;


import com.graduation.demo.entity.Course;
import com.graduation.demo.service.CourseService;
import com.graduation.demo.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  课程管理前端控制器
 *
 * @author 王奥
 * @since 2022-03-24
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    @PostMapping("/query")
    public DataResult query(){
        List<Course> courses = courseService.list();
        DataResult<List<Course>> result = new DataResult<>(courses);
        return result;
    }

    @PostMapping("/add")
    public DataResult add(Course course){
        courseService.save(course);
        return DataResult.success();
    }

    @PostMapping("/edit")
    public DataResult edit(Course course){
        courseService.updateById(course);
        return DataResult.success();
    }

    @PostMapping("/remove")
    public DataResult remove(List<String> ids){
        courseService.removeByIds(ids);
        return DataResult.success();
    }
}

