package com.graduation.demo.controller;


import com.graduation.demo.entity.Student;
import com.graduation.demo.service.StudentService;
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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public void add(Student student){
        studentService.save(student);
    }

    @PostMapping("/add")
    public void edit(Student student){
        studentService.updateById(student);
    }

    @PostMapping("/remove")
    public void remove(List<String> ids){
        studentService.removeByIds(ids);
    }
}

