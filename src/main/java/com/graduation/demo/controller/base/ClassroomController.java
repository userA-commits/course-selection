package com.graduation.demo.controller.base;


import com.graduation.demo.entity.Classroom;
import com.graduation.demo.entity.Classroom;
import com.graduation.demo.service.ClassroomService;
import com.graduation.demo.utils.DataResult;
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

    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    @PostMapping("/query")
    public DataResult query(){
        List<Classroom> classrooms = classroomService.list();
        DataResult<List<Classroom>> result = new DataResult<>(classrooms);
        return result;
    }

    @PostMapping("/add")
    public DataResult add(Classroom classroom){
        classroomService.save(classroom);
        return DataResult.success();
    }

    @PostMapping("/edit")
    public DataResult edit(Classroom classroom){
        classroomService.updateById(classroom);
        return DataResult.success();
    }

    @PostMapping("/remove")
    public DataResult remove(List<String> ids){
        classroomService.removeByIds(ids);
        return DataResult.success();
    }
}

