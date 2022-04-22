package com.graduation.demo.controller.base;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.demo.common.Constant;
import com.graduation.demo.entity.base.Teacher;
import com.graduation.demo.service.TeacherService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.vo.base.TeacherVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 教师管理控制器
 *
 * @author 王奥
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/loadAllTeacher")
    public DataResult loadAllTeacher(TeacherVo teacherVo){
        //覆盖分页功能
        IPage<Teacher> page = new Page<>(teacherVo.getPage(), teacherVo.getLimit());
        //覆盖条件查询功能
        teacherService.page(page, new QueryWrapper<Teacher>()
                .like(StringUtils.isNotBlank(teacherVo.getDeptNo()), "dept_no", teacherVo.getDeptNo())
                .like(StringUtils.isNotBlank(teacherVo.getTeacherNo()), "teacher_no", teacherVo.getTeacherNo())
                .like(StringUtils.isNotBlank(teacherVo.getName()), "name", teacherVo.getName())
                .eq(teacherVo.getSex() != null, "sex", teacherVo.getSex())
                .like(StringUtils.isNotBlank(teacherVo.getPosition()), "position", teacherVo.getPosition())
                .orderByAsc("teacher_no")
        );
        return DataResult.success(page.getRecords());
    }

    @RequestMapping("/addTeacher")
    public DataResult addTeacher(TeacherVo teacherVo){
        try{
            teacherVo.setUserType(2);
            this.teacherService.save(teacherVo);
            return Constant.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.ADD_ERROR;
        }
    }

    @RequestMapping("/updateTeacher")
    public DataResult updateTeacher(TeacherVo teacherVo){
        try{
            this.teacherService.updateById(teacherVo);
            return Constant.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.UPDATE_ERROR;
        }
    }

    @RequestMapping("/deleteTeacher")
    public DataResult deleteTeacher(String id){
        try{
            teacherService.removeById(id);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

    @RequestMapping("/batchDeleteTeacher")
    public DataResult batchDeleteTeacherList(TeacherVo teacherVo){
        try{
            List<String> ids = new ArrayList<>(Arrays.asList(teacherVo.getIds()));
            teacherService.removeByIds(ids);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }


}
