package com.graduation.demo.controller;


import com.graduation.demo.entity.Course;
import com.graduation.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王奥
 * @since 2022-03-11
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public void add(Course course){
        courseService.save(course);
    }

    @PostMapping("/add")
    public void edit(Course course){
        courseService.updateById(course);
    }

    @PostMapping("/remove")
    public void remove(List<String> ids){
        courseService.removeByIds(ids);
    }
}

