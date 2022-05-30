package com.graduation.demo.controller.base;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.demo.common.Constant;
import com.graduation.demo.entity.base.Clazz;
import com.graduation.demo.entity.base.Student;
import com.graduation.demo.service.ClazzService;
import com.graduation.demo.service.StudentService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.vo.base.StudentVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 学生管理控制器
 *
 * @author 王奥
 * @since 2022-03-11
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    ClazzService clazzService;

    @RequestMapping("/loadAllStudent")
    public DataResult loadAllStudent(StudentVo studentVo){
        //覆盖分页功能
        IPage<Student> page = new Page<>(studentVo.getPage(), studentVo.getLimit());
        //覆盖条件查询功能
        studentService.page(page, new QueryWrapper<Student>()
                .like(StringUtils.isNotBlank(studentVo.getDeptNo()), "dept_no", studentVo.getDeptNo())
                .like(StringUtils.isNotBlank(studentVo.getMajorNo()), "major_no", studentVo.getMajorNo())
                .like(StringUtils.isNotBlank(studentVo.getClazzNo()), "clazz_no", studentVo.getClazzNo())
                .like(StringUtils.isNotBlank(studentVo.getStudentNo()), "student_no", studentVo.getStudentNo())
                .like(StringUtils.isNotBlank(studentVo.getName()), "name", studentVo.getName())
                .like(null !=studentVo.getGrade(), "grade", studentVo.getGrade())
                .eq(studentVo.getSex() != null, "sex", studentVo.getSex())
                .orderByAsc("student_no")
        );
        return DataResult.success(page.getRecords());
    }

    @RequestMapping("/addStudent")
    public DataResult addStudent(StudentVo studentVo){
        try{
            Clazz clazz = clazzService.getOne(new QueryWrapper<Clazz>()
                    .select("grade, student_num")
                    .eq("clazz_no", studentVo.getClazzNo())
            );
            clazzService.increaseStudentNumByStuNo(studentVo);
            studentVo.setUserType(3);
            studentVo.setGrade(clazz.getGrade());
            this.studentService.save(studentVo);
            return Constant.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.ADD_ERROR;
        }
    }

    @RequestMapping("/updateStudent")
    public DataResult updateStudent(StudentVo studentVo){
        try{
            studentVo.setGrade(
                    clazzService.getOne(new QueryWrapper<Clazz>()
                            .select("grade")
                            .eq("clazz_no", studentVo.getClazzNo()))
                            .getGrade()
            );
            this.studentService.updateById(studentVo);
            return Constant.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.UPDATE_ERROR;
        }
    }

    @RequestMapping("/deleteStudent")
    public DataResult deleteStudent(String id){
        try{
            clazzService.decreaseStudentNumByStuNo(id);
            studentService.removeById(id);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

    @RequestMapping("/batchDeleteStudent")
    public DataResult batchDeleteStudentList(StudentVo studentVo){
        try{
            List<String> ids = new ArrayList<>(Arrays.asList(studentVo.getIds()));
            for(String id : ids){
                clazzService.decreaseStudentNumByStuNo(id);
            }
            studentService.removeByIds(ids);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }
}
