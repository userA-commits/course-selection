package com.graduation.demo.mapper;


import com.graduation.demo.entity.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}