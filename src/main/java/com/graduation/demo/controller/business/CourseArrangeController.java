package com.graduation.demo.controller.business;


import com.graduation.demo.entity.CourseArrange;
import com.graduation.demo.service.CourseArrangeService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.vo.CourseArrangeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 排课管理前端控制器
 * @author 王奥
 * @since 2022-04-11
 */
@RestController
@RequestMapping("/course-arrange")
public class CourseArrangeController {
    @Autowired
    CourseArrangeService courseArrangeService;

    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    @PostMapping("/getCourseArrangeVos")
    public DataResult getCourseArrangeVos(){
        List<CourseArrangeVo> courseArrangeVos = courseArrangeService.getCourseArrangeVo();
        DataResult<List<CourseArrangeVo>> result = new DataResult<>(courseArrangeVos);
        return result;
    }

    @PostMapping("/getCourseArrangeVosWithCond")
    public DataResult getCourseArrangeVosWithCond(CourseArrange courseArrange){
        List<CourseArrangeVo> courseArrangeVos = courseArrangeService.getCourseArrangeVoWithCond(courseArrange);
        DataResult<List<CourseArrangeVo>> result = new DataResult<>(courseArrangeVos);
        return result;
    }

    @PostMapping("/query")
    public DataResult query(){
        List<CourseArrange> courseArranges = courseArrangeService.list();
        DataResult<List<CourseArrange>> result = new DataResult<>(courseArranges);
        return result;
    }

    @PostMapping("/add")
    public DataResult add(CourseArrange courseArrange){
        courseArrangeService.save(courseArrange);
        return DataResult.success();
    }

    @PostMapping("/edit")
    public DataResult edit(CourseArrange courseArrange){
        courseArrangeService.updateById(courseArrange);
        return DataResult.success();
    }

    @PostMapping("/remove")
    public DataResult remove(List<String> ids){
        courseArrangeService.removeByIds(ids);
        return DataResult.success();
    }
}


