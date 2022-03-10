package com.graduation.demo.mapper;


import com.graduation.demo.entity.Rt;

public interface RtMapper {
    int insert(Rt record);

    int insertSelective(Rt record);
}