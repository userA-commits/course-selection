package com.graduation.demo.controller.base;


import com.graduation.demo.entity.Dept;
import com.graduation.demo.service.DeptService;
import com.graduation.demo.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 学院管理控制器
 *
 * @author 王奥
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    DeptService deptService;

    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    @PostMapping("/query")
    public DataResult query(){
        List<Dept> depts = deptService.list();
        DataResult<List<Dept>> result = new DataResult<>(depts);
        return result;
    }

    @PostMapping("/add")
    public DataResult add(Dept dept){
        deptService.save(dept);
        return DataResult.success();
    }

    @PostMapping("/edit")
    public DataResult edit(Dept dept){
        deptService.updateById(dept);
        return DataResult.success();
    }

    @PostMapping("/remove")
    public DataResult remove(List<String> ids){
        deptService.removeByIds(ids);
        return DataResult.success();
    }
}


