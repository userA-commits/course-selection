package com.graduation.demo.controller.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.demo.common.Constant;
import com.graduation.demo.entity.base.Admin;
import com.graduation.demo.service.AdminService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.vo.base.AdminVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  管理员管理前端控制器
 *
 * @author 王奥
 * @since 2022-03-11
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/loadAllAdmin")
    public DataResult loadAllAdmin(AdminVo adminVo){
        //覆盖分页功能
        IPage<Admin> page = new Page<>(adminVo.getPage(), adminVo.getLimit());
        //覆盖条件查询功能
        adminService.page(page, new QueryWrapper<Admin>()
                .like(StringUtils.isNotBlank(adminVo.getAdminNo()), "admin_no", adminVo.getAdminNo())
                .like(StringUtils.isNotBlank(adminVo.getPassword()), "password", adminVo.getPassword())
                .like(StringUtils.isNotBlank(adminVo.getEmail()), "admin_no", adminVo.getEmail())
                .orderByAsc("admin_no")
        );
        return DataResult.success(page.getRecords());
    }

    @RequestMapping("/addAdmin")
    public DataResult addAdmin(AdminVo adminVo){
        try{
            adminVo.setUserType(1);
            this.adminService.save(adminVo);
            return Constant.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.ADD_ERROR;
        }
    }

    @RequestMapping("/updateAdmin")
    public DataResult updateAdmin(AdminVo adminVo){
        try{
            this.adminService.updateById(adminVo);
            return Constant.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.UPDATE_ERROR;
        }
    }

    @RequestMapping("/deleteAdmin")
    public DataResult deleteAdmin(String id){
        try{
            adminService.removeById(id);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

    @RequestMapping("/batchDeleteAdmin")
    public DataResult batchDeleteAdminList(AdminVo adminVo){
        try{
            List<String> ids = new ArrayList<>(Arrays.asList(adminVo.getIds()));
            adminService.removeByIds(ids);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }
}
