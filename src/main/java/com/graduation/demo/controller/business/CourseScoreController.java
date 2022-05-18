package com.graduation.demo.controller.business;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.demo.common.ActiveUser;
import com.graduation.demo.common.Constant;
import com.graduation.demo.entity.business.SelectCourse;
import com.graduation.demo.entity.business.TeachCourse;
import com.graduation.demo.service.SelectCourseService;
import com.graduation.demo.service.TeachCourseService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.utils.SemesterUtils;
import com.graduation.demo.utils.WEBUtils;
import com.graduation.demo.vo.business.SelectCourseVo;
import com.graduation.demo.vo.business.TeachCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 成绩管理前端控制器
 *
 * @author 王奥
 * @since 2022-04-11
 */
@RestController
@RequestMapping("/courseScore")
public class CourseScoreController {
    @Autowired
    SelectCourseService selectCourseService;

    @RequestMapping("/loadAllCourseScore")
    public DataResult loadAllCourseScore(SelectCourseVo selectCourseVo){
        //覆盖分页功能
        IPage<SelectCourseVo> page = new Page<>(selectCourseVo.getPage(), selectCourseVo.getLimit());
        //覆盖条件查询功能
        selectCourseService.loadAllSelectCourse(page, selectCourseVo);

        return DataResult.success(page.getRecords());
    }

    @RequestMapping("/loadCourseScoreForStu")
    public DataResult loadCourseScoreForStu(SelectCourseVo selectCourseVo){
        //获取学生信息
        ActiveUser user = (ActiveUser) WEBUtils.getSession().getAttribute("user");
        //填入学生编号
        String studentNo = user.getStudent().getStudentNo();
        selectCourseVo.setStudentNo(studentNo);
        //覆盖分页功能
        IPage<SelectCourseVo> page = new Page<>(selectCourseVo.getPage(), selectCourseVo.getLimit());
        //覆盖条件查询功能
        selectCourseService.loadAllSelectCourse(page, selectCourseVo);

        return DataResult.success(page.getRecords());
    }

    @RequestMapping("/updateCourseScore")
    public DataResult updateCourseScore(SelectCourseVo selectCourseVo){
        try{
            this.selectCourseService.updateById(selectCourseVo);
            return Constant.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.UPDATE_ERROR;
        }
    }

}

