package com.graduation.demo.controller.base;


import com.graduation.demo.entity.Student;
import com.graduation.demo.service.StudentService;
import com.graduation.demo.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 学生管理控制器
 *
 * @author 王奥
 * @since 2022-03-11
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    @PostMapping("/query")
    public DataResult query(){
        List<Student> students = studentService.list();
        DataResult<List<Student>> result = new DataResult<>(students);
        return result;
    }

    @PostMapping("/add")
    public DataResult add(Student student){
        studentService.save(student);
        return DataResult.success();
    }

    @PostMapping("/edit")
    public DataResult edit(Student student){
        studentService.updateById(student);
        return DataResult.success();
    }

    @PostMapping("/remove")
    public DataResult remove(List<String> ids){
        studentService.removeByIds(ids);
        return DataResult.success();
    }
}
