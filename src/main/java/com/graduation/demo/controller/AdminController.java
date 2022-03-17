package com.graduation.demo.controller;


import com.graduation.demo.entity.Admin;
import com.graduation.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public void add(Admin admin){
        adminService.save(admin);
    }

    @PostMapping("/edit")
    public void edit(Admin admin){
        adminService.updateById(admin);
    }

    @PostMapping("/remove")
    public void remove(List<String> ids){
        adminService.removeByIds(ids);
    }
}

