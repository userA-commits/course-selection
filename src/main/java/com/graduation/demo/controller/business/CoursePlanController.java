package com.graduation.demo.controller.business;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.demo.common.Constant;
import com.graduation.demo.entity.business.CoursePlan;
import com.graduation.demo.service.CoursePlanService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.vo.business.CoursePlanVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 教学计划管理前端控制器
 *
 * @author 王奥
 * @since 2022-04-11
 */
@RestController
@RequestMapping("/coursePlan")
public class CoursePlanController {
    @Autowired
    CoursePlanService coursePlanService;

    @RequestMapping("/loadAllCoursePlan")
    public DataResult loadAllCoursePlan(CoursePlanVo coursePlanVo){
        //覆盖分页功能
        IPage<CoursePlanVo> page = new Page<>(coursePlanVo.getPage(), coursePlanVo.getLimit());
        //覆盖条件查询功能
        coursePlanService.loadAllCoursePlan(page, coursePlanVo);

        return DataResult.success(page.getRecords());
    }

    @RequestMapping("/addCoursePlan")
    public DataResult addCoursePlan(CoursePlanVo coursePlanVo){
        try{
            this.coursePlanService.save(coursePlanVo);
            return Constant.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.ADD_ERROR;
        }
    }

    @RequestMapping("/updateCoursePlan")
    public DataResult updateCoursePlan(CoursePlanVo coursePlanVo){
        try{
            this.coursePlanService.updateById(coursePlanVo);
            return Constant.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.UPDATE_ERROR;
        }
    }

    @RequestMapping("/deleteCoursePlan")
    public DataResult deleteCoursePlan(String id){
        try{
            coursePlanService.removeById(id);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

    @RequestMapping("/batchDeleteCoursePlan")
    public DataResult batchDeleteCoursePlanList(CoursePlanVo coursePlanVo){
        try{
            List<String> ids = new ArrayList<>(Arrays.asList(coursePlanVo.getIds()));
            coursePlanService.removeByIds(ids);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }


}


