package com.graduation.demo.controller.base;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.demo.common.ActiveUser;
import com.graduation.demo.common.Constant;
import com.graduation.demo.entity.Dept;
import com.graduation.demo.service.DeptService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.utils.WEBUtils;
import com.graduation.demo.vo.base.DeptVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 学院管理控制器
 *
 * @author 王奥
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    DeptService deptService;

    @RequestMapping("/loadAllDept")
    public DataResult loadAllDept(DeptVo deptVo){
        //覆盖分页功能
        IPage<Dept> page = new Page<>(deptVo.getPage(), deptVo.getLimit());
        //覆盖条件查询功能
        deptService.page(page, new QueryWrapper<Dept>()
                .like(StringUtils.isNotBlank(deptVo.getDeptNo()), "dept_no", deptVo.getDeptNo())
                .like(StringUtils.isNotBlank(deptVo.getName()), "name", deptVo.getName())
                .orderByAsc("dept_no")
        );
        return DataResult.success(page.getRecords());
    }

    @RequestMapping("/addDept")
    public DataResult addDept(DeptVo deptVo){
        try{
            this.deptService.save(deptVo);
            return Constant.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.ADD_ERROR;
        }
    }

    @RequestMapping("/updateDept")
    public DataResult updateDept(DeptVo deptVo){
        try{
            this.deptService.updateById(deptVo);
            return Constant.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.UPDATE_ERROR;
        }
    }

    @RequestMapping("/deleteDept")
    public DataResult deleteDept(String id){
        try{
            deptService.removeById(id);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

    @RequestMapping("/batchDeleteDept")
    public DataResult batchDeleteDeptList(DeptVo deptVo){
        try{
            List<String> ids = new ArrayList<>(Arrays.asList(deptVo.getIds()));
            deptService.removeByIds(ids);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

}


