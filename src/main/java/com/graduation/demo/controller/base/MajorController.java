package com.graduation.demo.controller.base;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.demo.common.Constant;
import com.graduation.demo.entity.Major;
import com.graduation.demo.service.MajorService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.vo.base.MajorVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 专业管理控制器
 *
 * @author 王奥
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/major")
public class MajorController {
    @Autowired
    MajorService majorService;

    @RequestMapping("/loadAllMajor")
    public DataResult loadAllMajor(MajorVo majorVo){
        //覆盖分页功能
        IPage<Major> page = new Page<>(majorVo.getPage(), majorVo.getLimit());
        //覆盖条件查询功能
        majorService.page(page, new QueryWrapper<Major>()
                .like(StringUtils.isNotBlank(majorVo.getDeptNo()), "dept_no", majorVo.getDeptNo())
                .like(StringUtils.isNotBlank(majorVo.getMajorNo()), "major_no", majorVo.getMajorNo())
                .like(StringUtils.isNotBlank(majorVo.getName()), "name", majorVo.getName())
                .orderByAsc("major_no")
        );
        return DataResult.success(page.getRecords());
    }

    @RequestMapping("/addMajor")
    public DataResult addMajor(MajorVo majorVo){
        try{
            this.majorService.save(majorVo);
            return Constant.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.ADD_ERROR;
        }
    }

    @RequestMapping("/updateMajor")
    public DataResult updateMajor(MajorVo majorVo){
        try{
            this.majorService.updateById(majorVo);
            return Constant.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.UPDATE_ERROR;
        }
    }

    @RequestMapping("/deleteMajor")
    public DataResult deleteMajor(String id){
        try{
            majorService.removeById(id);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

    @RequestMapping("/batchDeleteMajor")
    public DataResult batchDeleteMajorList(MajorVo majorVo){
        try{
            List<String> ids = new ArrayList<>(Arrays.asList(majorVo.getIds()));
            majorService.removeByIds(ids);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

}



