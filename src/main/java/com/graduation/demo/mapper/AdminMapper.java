package com.graduation.demo.mapper;


import com.graduation.demo.entity.Admin;

public interface AdminMapper {
    int insert(Admin record);

    int insertSelective(Admin record);
}