package com.graduation.demo.controller.business;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.demo.common.Constant;
import com.graduation.demo.entity.business.CourseArrange;
import com.graduation.demo.service.CourseArrangeService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.vo.business.CourseArrangeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排课管理前端控制器
 * @author 王奥
 * @since 2022-04-11
 */
@RestController
@RequestMapping("/courseArrange")
public class CourseArrangeController {

    @Autowired
    CourseArrangeService courseArrangeService;

    @RequestMapping("/loadAllCourseArrange")
    public DataResult loadAllCourseArrange(CourseArrangeVo courseArrangeVo){
        //覆盖分页功能
        IPage<CourseArrangeVo> page = new Page<>(courseArrangeVo.getPage(), courseArrangeVo.getLimit());
        //覆盖条件查询功能
        courseArrangeService.loadAllCourseArrange(page, courseArrangeVo);
        return DataResult.success(page.getRecords());
    }

    @RequestMapping("/addCourseArrange")
    public DataResult addCourseArrange(CourseArrangeVo courseArrangeVo){
        try{
            this.courseArrangeService.addWithConflictCheck(courseArrangeVo);
            return Constant.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return DataResult.getResult(401, e.getMessage());
        }
    }

    @RequestMapping("/updateCourseArrange")
    public DataResult updateCourseArrange(CourseArrangeVo courseArrangeVo){
        try{
            if(!courseArrangeService.haveConflict(courseArrangeVo)){
                this.courseArrangeService.updateById(courseArrangeVo);
            }
            return Constant.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return DataResult.getResult(401, e.getMessage());
        }
    }

    @RequestMapping("/deleteCourseArrange")
    public DataResult deleteCourseArrange(String id){
        try{
            courseArrangeService.removeById(id);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

    @RequestMapping("/batchDeleteCourseArrange")
    public DataResult batchDeleteCourseArrangeList(CourseArrangeVo courseArrangeVo){
        try{
            List<String> ids = new ArrayList<>(Arrays.asList(courseArrangeVo.getIds()));
            courseArrangeService.removeByIds(ids);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }


}


