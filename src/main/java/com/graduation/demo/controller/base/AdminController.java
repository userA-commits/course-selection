package com.graduation.demo.controller.base;


import com.graduation.demo.entity.base.Admin;
import com.graduation.demo.service.AdminService;
import com.graduation.demo.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    @PostMapping("/query")
    public DataResult query(){
        List<Admin> admins = adminService.list();
        DataResult<List<Admin>> result = new DataResult<>(admins);
        return result;
    }

    @PostMapping("/add")
    public DataResult add(Admin admin){
        adminService.save(admin);
        return DataResult.success();
    }

    @PostMapping("/edit")
    public DataResult edit(Admin admin){
        adminService.updateById(admin);
        return DataResult.success();
    }

    @PostMapping("/remove")
    public DataResult remove(List<String> ids){
        adminService.removeByIds(ids);
        return DataResult.success();
    }
}
