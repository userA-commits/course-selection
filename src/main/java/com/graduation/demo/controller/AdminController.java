package com.graduation.demo.controller;

import com.graduation.demo.entity.Admin;
import com.graduation.demo.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Api(value = "/admin", tags = "管理员管理")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "查找所有管理员")
    @PostMapping("/findAll")
    public String findAll(){
        return "admin";
    }
}
