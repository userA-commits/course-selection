package com.graduation.demo.mapper;

import com.graduation.demo.entity.Course;
import com.graduation.demo.entity.CourseExample;
import com.graduation.demo.entity.CourseWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int insert(CourseWithBLOBs record);

    int insertSelective(CourseWithBLOBs record);

    List<CourseWithBLOBs> selectByExampleWithBLOBs(CourseExample example);

    List<Course> selectByExample(CourseExample example);

    int updateByExampleSelective(@Param("record") CourseWithBLOBs record, @Param("example") CourseExample example);

    int updateByExampleWithBLOBs(@Param("record") CourseWithBLOBs record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);
}