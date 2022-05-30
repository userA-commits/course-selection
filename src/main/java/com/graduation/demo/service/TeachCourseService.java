package com.graduation.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduation.demo.entity.business.TeachCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.demo.vo.business.TeachCourseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王奥
 * @since 2022-04-11
 */
public interface TeachCourseService extends IService<TeachCourse> {
    //分页条件查询授课信息
    IPage<TeachCourseVo> loadAllTeachCourse(IPage<TeachCourseVo> page, TeachCourseVo teachCourseVo);
    //条件查询授课信息
    List<TeachCourseVo> loadAllTeachCourse(TeachCourseVo teachCourseVo);
    //检查插入的授课信息中，教师是否与课程在同学院
    boolean isSameDept(TeachCourseVo teachCourseVo);
    //插入必修课授课信息同时插入对应学生选课信息
    boolean saveRequired(TeachCourseVo teachCourseVo);
    //删除必修课授课信息同时删除对应学生选课信息
    boolean removeRequired(List<String> ids);
    boolean removeRequired(String id);

}
