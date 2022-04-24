package com.graduation.demo.controller.business;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.graduation.demo.entity.business.SelectCourse;
import com.graduation.demo.entity.business.TeachCourse;
import com.graduation.demo.service.SelectCourseService;
import com.graduation.demo.service.TeachCourseService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.vo.business.SelectCourseVo;
import com.graduation.demo.vo.business.TeachCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 成绩管理前端控制器
 *
 * @author 王奥
 * @since 2022-04-11
 */
@RestController
@RequestMapping("/courseScore")
public class CourseScoreController {
}

