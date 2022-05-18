package com.graduation.demo.controller.base;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.demo.common.Constant;
import com.graduation.demo.entity.base.Course;
import com.graduation.demo.service.CourseService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.vo.base.CourseVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  课程管理前端控制器
 *
 * @author 王奥
 * @since 2022-03-24
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping("/loadAllCourse")
    public DataResult loadAllCourse(CourseVo courseVo){
        //覆盖分页功能a
        IPage<Course> page = new Page<>(courseVo.getPage(), courseVo.getLimit());
        //覆盖条件查询功能
        courseService.page(page, new QueryWrapper<Course>()
                .like(StringUtils.isNotBlank(courseVo.getCourseNo()), "course_no", courseVo.getCourseNo())
                .like(StringUtils.isNotBlank(courseVo.getName()), "name", courseVo.getName())
                .orderByAsc("course_no")
        );
        return DataResult.success(page.getRecords());
    }

    @RequestMapping("/addCourse")
    public DataResult addCourse(CourseVo courseVo){
        try{
            this.courseService.save(courseVo);
            return Constant.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.ADD_ERROR;
        }
    }

    @RequestMapping("/updateCourse")
    public DataResult updateCourse(CourseVo courseVo){
        try{
            this.courseService.updateById(courseVo);
            return Constant.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.UPDATE_ERROR;
        }
    }

    @RequestMapping("/deleteCourse")
    public DataResult deleteCourse(String id){
        try{
            courseService.removeById(id);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

    @RequestMapping("/batchDeleteCourse")
    public DataResult batchDeleteCourseList(CourseVo courseVo){
        try{
            List<String> ids = new ArrayList<>(Arrays.asList(courseVo.getIds()));
            courseService.removeByIds(ids);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }



}

