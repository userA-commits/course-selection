package com.graduation.demo.mapper;


import com.graduation.demo.entity.Sc;

public interface ScMapper {
    int insert(Sc record);

    int insertSelective(Sc record);
}