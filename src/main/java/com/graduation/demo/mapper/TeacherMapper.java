package com.graduation.demo.mapper;

import com.graduation.demo.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduation.demo.po.TeacherWithCourse;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王奥
 * @since 2022-03-19
 */
public interface TeacherMapper extends BaseMapper<Teacher> {
    List<TeacherWithCourse> getTeacherWithCourse(String tid);
}
