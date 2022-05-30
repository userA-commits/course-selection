package com.graduation.demo.controller.business;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.demo.common.ActiveUser;
import com.graduation.demo.common.Constant;
import com.graduation.demo.entity.business.SelectCourse;
import com.graduation.demo.service.SelectCourseService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.utils.SemesterUtils;
import com.graduation.demo.utils.WEBUtils;
import com.graduation.demo.vo.business.SelectCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 选课管理前端控制器
 *
 * @author 王奥
 * @since 2022-04-11
 */
@RestController
@RequestMapping("/selectCourse")
public class SelectCourseController {
    @Autowired
    SelectCourseService selectCourseService;

    @RequestMapping("/loadAllSelectCourse")
    public DataResult loadAllSelectCourse(SelectCourseVo selectCourseVo){
        //覆盖分页功能
        IPage<SelectCourseVo> page = new Page<>(selectCourseVo.getPage(), selectCourseVo.getLimit());
        //覆盖条件查询功能
        selectCourseService.loadAllSelectCourse(page, selectCourseVo);

        return DataResult.success(page.getRecords());
    }

    @RequestMapping("/addSelectCourse")
    public DataResult addSelectCourse(SelectCourseVo selectCourseVo){
        try{
            //获取学生信息
            ActiveUser user = (ActiveUser) WEBUtils.getSession().getAttribute("user");
            //填入学生编号和学期
            String studentNo = user.getStudent().getStudentNo();
            int semester = SemesterUtils.getSemester(user.getStudent().getGrade());
            selectCourseVo.setStudentNo(studentNo);
            selectCourseVo.setSemester(semester);
            this.selectCourseService.addWithCheck(selectCourseVo);
            return Constant.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return DataResult.getResult(401, e.getMessage());
        }
    }

    @RequestMapping("/deleteSelectCourse")
    public DataResult deleteSelectCourse(String id){
        try{
            selectCourseService.removeRequired(id);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

    @RequestMapping("/batchDeleteSelectCourse")
    public DataResult batchDeleteSelectCourseList(SelectCourseVo selectCourseVo){
        try{
            List<String> ids = new ArrayList<>(Arrays.asList(selectCourseVo.getIds()));
            selectCourseService.removeRequired(ids);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

}


