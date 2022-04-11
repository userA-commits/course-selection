package com.graduation.demo.controller.base;


import com.graduation.demo.entity.Clazz;
import com.graduation.demo.service.ClazzService;
import com.graduation.demo.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 班级管理控制器
 *
 * @author 王奥
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    ClazzService clazzService;

    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    @PostMapping("/query")
    public DataResult query(){
        List<Clazz> clazzs = clazzService.list();
        DataResult<List<Clazz>> result = new DataResult<>(clazzs);
        return result;
    }

    @PostMapping("/add")
    public DataResult add(Clazz clazz){
        clazzService.save(clazz);
        return DataResult.success();
    }

    @PostMapping("/edit")
    public DataResult edit(Clazz clazz){
        clazzService.updateById(clazz);
        return DataResult.success();
    }

    @PostMapping("/remove")
    public DataResult remove(List<String> ids){
        clazzService.removeByIds(ids);
        return DataResult.success();
    }
}



