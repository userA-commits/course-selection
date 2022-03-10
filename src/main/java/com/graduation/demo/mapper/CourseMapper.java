package com.graduation.demo.mapper;


import com.graduation.demo.entity.CourseWithBLOBs;

public interface CourseMapper {
    int insert(CourseWithBLOBs record);

    int insertSelective(CourseWithBLOBs record);
}