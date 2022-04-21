package com.graduation.demo.controller.business;


import com.graduation.demo.entity.CoursePlan;
import com.graduation.demo.service.CoursePlanService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.vo.business.CoursePlanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 教学计划管理前端控制器
 *
 * @author 王奥
 * @since 2022-04-11
 */
@RestController
@RequestMapping("/course-plan")
public class CoursePlanController {
    @Autowired
    CoursePlanService coursePlanService;

    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    //用于获取对应年级专业的所有教学计划信息
    @PostMapping("/getCoursePlanVosByCond")
    public DataResult getCoursePlanVosByCond(CoursePlan coursePlan){
        List<CoursePlanVo> coursePlanVos = coursePlanService.getCoursePlanVoWithCond(coursePlan);
        DataResult<List<CoursePlanVo>> result = new DataResult<>(coursePlanVos);
        return result;
    }

    @PostMapping("/getCoursePlanVos")
    public DataResult getCoursePlanVos(){
        List<CoursePlanVo> coursePlanVos = coursePlanService.getCoursePlanVo();
        DataResult<List<CoursePlanVo>> result = new DataResult<>(coursePlanVos);
        return result;
    }

    @PostMapping("/query")
    public DataResult query(){
        List<CoursePlan> coursePlans = coursePlanService.list();
        DataResult<List<CoursePlan>> result = new DataResult<>(coursePlans);
        return result;
    }

    @PostMapping("/add")
    public DataResult add(CoursePlan coursePlan){
        coursePlanService.save(coursePlan);
        return DataResult.success();
    }

    @PostMapping("/edit")
    public DataResult edit(CoursePlan coursePlan){
        coursePlanService.updateById(coursePlan);
        return DataResult.success();
    }

    @PostMapping("/remove")
    public DataResult remove(List<String> ids){
        coursePlanService.removeByIds(ids);
        return DataResult.success();
    }
}


