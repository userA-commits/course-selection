package com.graduation.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.graduation.demo.entity.Course;
import com.graduation.demo.entity.CourseArrange;
import com.graduation.demo.entity.SelectCourse;
import com.graduation.demo.entity.TeachCourse;
import com.graduation.demo.mapper.SelectCourseMapper;
import com.graduation.demo.service.CourseArrangeService;
import com.graduation.demo.service.CourseService;
import com.graduation.demo.service.SelectCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.demo.service.TeachCourseService;
import com.graduation.demo.vo.business.SelectCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王奥
 * @since 2022-04-11
 */
@Service
public class SelectCourseServiceImpl extends ServiceImpl<SelectCourseMapper, SelectCourse> implements SelectCourseService {
    @Autowired
    @Lazy
    CourseArrangeService courseArrangeService;
    @Autowired
    @Lazy
    TeachCourseService teachCourseService;
    @Autowired
    CourseService courseService;

    @Override
    public List<SelectCourseVo> getSelectCourseVo() {
        return this.getBaseMapper().getSelectCourseVo();
    }

    @Override
    public List<SelectCourseVo> getSelectCourseVoWithCond(SelectCourse selectCourse) {
        return this.getBaseMapper().getSelectCourseVoWithCond(selectCourse);
    }

    @Override
    public String addWithCheck(SelectCourse selectCourse) {
        //检测能否进行选课和是否有冲突
        if(isSelectable(selectCourse) && haveConflict(selectCourse) == null){
            //存储选课
            this.save(selectCourse);
            //为授课信息中选课人数加一
            TeachCourse teachCourse = teachCourseService.getOne(new QueryWrapper<TeachCourse>()
                    .select("student_num")
                    .eq("teach_course_no", selectCourse.getTeachCourseNo())
            );
            teachCourseService.update(new UpdateWrapper<TeachCourse>()
                    .set("student_num", teachCourse.getStudentNum() + 1)
            );
            return "OK";
        }else if(!isSelectable(selectCourse)){
            return "Can't Select";
        }else{
            return "Have Conflict";
        }
    }

    @Override
    public boolean removeRequired(List<String> ids) {
        //通过ids获得选课信息列表
        List<SelectCourse> selectCourseList = (List<SelectCourse>) this.listByIds(ids);
        //遍历选课信息列表
        for(SelectCourse selectCourse : selectCourseList){
            //通过授课编号查看课程编号，再查看课程是否为选修课
            TeachCourse teachCourse = teachCourseService.getOne(new QueryWrapper<TeachCourse>()
                    .select("course_no, upper_num, student_num")
                    .eq("teach_course_no", selectCourse.getTeachCourseNo())
            );
            Course course = courseService.getOne(new QueryWrapper<Course>()
                    .select("is_required")
                    .eq("course_no", teachCourse.getCourseNo())
            );
            //若课程为选修课，则允许删除
            if(course.getIsRequired() == 0){
                //删除选课
                this.removeById(selectCourse.getId());
                //为授课信息中选课人数减一
                teachCourseService.update(new UpdateWrapper<TeachCourse>()
                        .set("student_num", teachCourse.getStudentNum() - 1)
                );
            }
        }
        return true;
    }

    //断定当前课程是否可选
    @Override
    public boolean isSelectable(SelectCourse selectCourse) {
        //通过授课编号查看课程编号，再查看课程是否为选修课
        TeachCourse teachCourse = teachCourseService.getOne(new QueryWrapper<TeachCourse>()
                .select("course_no, upper_num, student_num")
                .eq("teach_course_no", selectCourse.getTeachCourseNo())
        );
        Course course = courseService.getOne(new QueryWrapper<Course>()
                .select("is_required")
                .eq("course_no", teachCourse.getCourseNo())
        );
        if(course.getIsRequired() == 1) return false;
        //查看通过授课编号查看当前课程是否有位置
        if(teachCourse.getUpperNum() <= teachCourse.getStudentNum()) return false;
        return true;
    }

    //对选课信息进行冲突检测
    @Override
    public CourseArrange haveConflict(SelectCourse selectCourse){
        //对学生课程安排进行检测
        //通过授课编号，获得当前选课的排课信息
        CourseArrange courseArrange = courseArrangeService.getOne(new QueryWrapper<CourseArrange>()
                .select("*")
                .eq("teach_course_no", selectCourse.getTeachCourseNo())
        );
        //通过学生编号，在选课表获得当前学生所有选课的授课信息
        List<SelectCourse> forTeachCourseNoList = this.list(new QueryWrapper<SelectCourse>()
                .select("teach_course_no")
                .eq("student_no", selectCourse.getStudentNo())
        );
        //遍历学生选课的排课表，查找是否存在与当前课程排课重合的课程
        for(SelectCourse forTeachCourseNo : forTeachCourseNoList){
            CourseArrange studentTest = courseArrangeService.getOne(new QueryWrapper<CourseArrange>()
                    .select("*")
                    .eq("teach_course_no", forTeachCourseNo.getTeachCourseNo())
                    .eq("week", courseArrange.getWeek())
                    .eq("period", courseArrange.getPeriod())
            );
            //若找到重合课程，返回该课程信息
            if(studentTest != null) return studentTest;
        }
        return null;
    }
}
