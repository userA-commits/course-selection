package com.graduation.demo.controller.base;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.demo.common.Constant;
import com.graduation.demo.entity.base.Classroom;
import com.graduation.demo.service.ClassroomService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.vo.base.ClassroomVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  教室管理前端控制器
 *
 * @author 王奥
 * @since 2022-03-11
 */
@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    ClassroomService classroomService;

    @RequestMapping("/loadAllClassroom")
    public DataResult loadAllClassroom(ClassroomVo classroomVo){
        //覆盖分页功能
        IPage<Classroom> page = new Page<>(classroomVo.getPage(), classroomVo.getLimit());
        //覆盖条件查询功能
        classroomService.page(page, new QueryWrapper<Classroom>()
                .like(StringUtils.isNotBlank(classroomVo.getClassroomNo()), "classroom_no", classroomVo.getClassroomNo())
                .like(StringUtils.isNotBlank(classroomVo.getName()), "name", classroomVo.getName())
                .eq(null != classroomVo.getClassroomType(), "classroom_type", classroomVo.getClassroomType())
                .like(StringUtils.isNotBlank(classroomVo.getBuild()), "build", classroomVo.getBuild())
                .orderByAsc("classroom_no")
        );
        return DataResult.success(page.getRecords());
    }

    @RequestMapping("/addClassroom")
    public DataResult addClassroom(ClassroomVo classroomVo){
        try{
            this.classroomService.save(classroomVo);
            return Constant.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.ADD_ERROR;
        }
    }

    @RequestMapping("/updateClassroom")
    public DataResult updateClassroom(ClassroomVo classroomVo){
        try{
            this.classroomService.updateById(classroomVo);
            return Constant.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.UPDATE_ERROR;
        }
    }

    @RequestMapping("/deleteClassroom")
    public DataResult deleteClassroom(String id){
        try{
            classroomService.removeById(id);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

    @RequestMapping("/batchDeleteClassroom")
    public DataResult batchDeleteClassroomList(ClassroomVo classroomVo){
        try{
            List<String> ids = new ArrayList<>(Arrays.asList(classroomVo.getIds()));
            classroomService.removeByIds(ids);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

}

