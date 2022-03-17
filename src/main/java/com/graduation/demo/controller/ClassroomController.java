package com.graduation.demo.controller;


import com.graduation.demo.entity.Classroom;
import com.graduation.demo.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  教室管理前端控制器
 *
 * @author 王奥
 * @since 2022-03-11
 */
@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    ClassroomService classroomService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public void add(Classroom classroom){
        classroomService.save(classroom);
    }

    @PostMapping("/edit")
    public void edit(Classroom classroom){
        classroomService.updateById(classroom);
    }

    @PostMapping("/remove")
    public void remove(List<String> ids){
        classroomService.removeByIds(ids);
    }
}

