package com.graduation.demo.mapper;


import com.graduation.demo.entity.Classroom;

public interface ClassroomMapper {
    int deleteByPrimaryKey(String rid);

    int insert(Classroom record);

    int insertSelective(Classroom record);

    Classroom selectByPrimaryKey(String rid);

    int updateByPrimaryKeySelective(Classroom record);

    int updateByPrimaryKey(Classroom record);
}