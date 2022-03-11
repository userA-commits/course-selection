package com.graduation.demo.controller;


import com.graduation.demo.entity.Admin;
import com.graduation.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王奥
 * @since 2022-03-11
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("/selectAll")
    public String selectAll(){
        List<Admin> adminList = adminService.list();
        for(Admin a : adminList){
            System.out.println(a);
        }
        return "index";
    }
}

