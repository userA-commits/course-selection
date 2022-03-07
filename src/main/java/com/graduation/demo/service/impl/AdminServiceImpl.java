package com.graduation.demo.service.impl;

import com.graduation.demo.entity.Admin;
import com.graduation.demo.mapper.AdminMapper;
import com.graduation.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> findAll() {
        return adminMapper.findAll();
    }
}
