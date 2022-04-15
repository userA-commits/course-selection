package com.graduation.demo.controller.business;


import com.graduation.demo.entity.SelectCourse;
import com.graduation.demo.service.SelectCourseService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.vo.SelectCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 选课管理前端控制器
 *
 * @author 王奥
 * @since 2022-04-11
 */
@RestController
@RequestMapping("/select-course")
public class SelectCourseController {
    @Autowired
    SelectCourseService selectCourseService;

    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    //用于获取对应学生的所有选课信息
    @PostMapping("/getSelectCourseVosByCond")
    public DataResult getSelectCourseVosByCond(SelectCourse selectCourse){
        List<SelectCourseVo> selectCourseVos = selectCourseService.getSelectCourseVoWithCond(selectCourse);
        DataResult<List<SelectCourseVo>> result = new DataResult<>(selectCourseVos);
        return result;
    }

    @PostMapping("/getSelectCourseVos")
    public DataResult getSelectCourseVos(){
        List<SelectCourseVo> selectCourseVos = selectCourseService.getSelectCourseVo();
        DataResult<List<SelectCourseVo>> result = new DataResult<>(selectCourseVos);
        return result;
    }

    @PostMapping("/query")
    public DataResult query(){
        List<SelectCourse> selectCourses = selectCourseService.list();
        DataResult<List<SelectCourse>> result = new DataResult<>(selectCourses);
        return result;
    }

    //只允许选择是选修并且存在人数空缺的课
    @PostMapping("/add")
    public DataResult add(SelectCourse selectCourse){
        String msg = selectCourseService.addWithCheck(selectCourse);
        if(msg.equals("OK")) return DataResult.success();
        else return DataResult.getResult(401, msg);
    }

    //只允许取消选修课。在删除选课时，自动减一对应的授课人数
    @PostMapping("/remove")
    public DataResult remove(List<String> ids){
        selectCourseService.removeRequired(ids);
        return DataResult.success();
    }
}


