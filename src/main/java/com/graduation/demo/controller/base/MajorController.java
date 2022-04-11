package com.graduation.demo.controller.base;


import com.graduation.demo.entity.Major;
import com.graduation.demo.service.MajorService;
import com.graduation.demo.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 专业管理控制器
 *
 * @author 王奥
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/major")
public class MajorController {
    @Autowired
    MajorService majorService;

    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    @PostMapping("/query")
    public DataResult query(){
        List<Major> majors = majorService.list();
        DataResult<List<Major>> result = new DataResult<>(majors);
        return result;
    }

    @PostMapping("/add")
    public DataResult add(Major major){
        majorService.save(major);
        return DataResult.success();
    }

    @PostMapping("/edit")
    public DataResult edit(Major major){
        majorService.updateById(major);
        return DataResult.success();
    }

    @PostMapping("/remove")
    public DataResult remove(List<String> ids){
        majorService.removeByIds(ids);
        return DataResult.success();
    }
}



