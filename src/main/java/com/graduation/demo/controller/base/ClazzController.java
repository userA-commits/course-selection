package com.graduation.demo.controller.base;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.demo.common.Constant;
import com.graduation.demo.entity.base.Clazz;
import com.graduation.demo.service.ClazzService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.vo.base.ClazzVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 班级管理控制器
 *
 * @author 王奥
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/clazz")
public class ClazzController {

    @Autowired
    ClazzService clazzService;

    @RequestMapping("/loadAllClazz")
    public DataResult loadAllClazz(ClazzVo clazzVo){
        //覆盖分页功能
        IPage<Clazz> page = new Page<>(clazzVo.getPage(), clazzVo.getLimit());
        //覆盖条件查询功能
        clazzService.page(page, new QueryWrapper<Clazz>()
                .like(StringUtils.isNotBlank(clazzVo.getClazzNo()), "clazz_no", clazzVo.getClazzNo())
                .like(StringUtils.isNotBlank(clazzVo.getMajorNo()), "major_no", clazzVo.getMajorNo())
                .like(StringUtils.isNotBlank(clazzVo.getGrade()), "grade", clazzVo.getGrade())
                .like(StringUtils.isNotBlank(clazzVo.getName()), "name", clazzVo.getName())
                .eq(null != clazzVo.getClazzType(), "clazz_type", clazzVo.getClazzType())
                .orderByAsc("clazz_no")
        );
        return DataResult.success(page.getRecords());
    }

    @RequestMapping("/addClazz")
    public DataResult addClazz(ClazzVo clazzVo){
        try{
            this.clazzService.save(clazzVo);
            return Constant.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.ADD_ERROR;
        }
    }

    @RequestMapping("/updateClazz")
    public DataResult updateClazz(ClazzVo clazzVo){
        try{
            this.clazzService.updateById(clazzVo);
            return Constant.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.UPDATE_ERROR;
        }
    }

    @RequestMapping("/deleteClazz")
    public DataResult deleteClazz(String id){
        try{
            clazzService.removeById(id);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

    @RequestMapping("/batchDeleteClazz")
    public DataResult batchDeleteClazzList(ClazzVo clazzVo){
        try{
            List<String> ids = new ArrayList<>(Arrays.asList(clazzVo.getIds()));
            clazzService.removeByIds(ids);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }


}



