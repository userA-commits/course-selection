package com.graduation.demo.controller;


import com.graduation.demo.entity.Teacher;
import com.graduation.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  教师管理前端控制器
 *
 * @author 王奥
 * @since 2022-03-11
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public void add(Teacher teacher){
        teacherService.save(teacher);
    }

    @PostMapping("/add")
    public void edit(Teacher teacher){
        teacherService.updateById(teacher);
    }

    @PostMapping("/remove")
    public void remove(List<String> ids){
        teacherService.removeByIds(ids);
    }

}

