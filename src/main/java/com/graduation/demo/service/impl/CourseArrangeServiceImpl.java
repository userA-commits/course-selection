package com.graduation.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduation.demo.entity.business.CourseArrange;
import com.graduation.demo.entity.business.TeachCourse;
import com.graduation.demo.mapper.CourseArrangeMapper;
import com.graduation.demo.service.CourseArrangeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.demo.service.TeachCourseService;
import com.graduation.demo.service.TeacherService;
import com.graduation.demo.vo.business.CourseArrangeVo;
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
public class CourseArrangeServiceImpl extends ServiceImpl<CourseArrangeMapper, CourseArrange> implements CourseArrangeService {
    @Autowired
    @Lazy
    TeachCourseService teachCourseService;
    @Autowired
    TeacherService teacherService;

    @Override
    public IPage<CourseArrangeVo> loadAllCourseArrange(IPage<CourseArrangeVo> page, CourseArrangeVo courseArrangeVo) {
        return this.getBaseMapper().loadAllCourseArrange(page, courseArrangeVo);
    }

    @Override
    public List<CourseArrangeVo> loadAllCourseArrange(CourseArrangeVo courseArrangeVo) {
        return this.getBaseMapper().loadAllCourseArrange(courseArrangeVo);
    }

    //对排课信息进行冲突检测，如发生冲突则报错
    @Override
    public boolean addWithConflictCheck(CourseArrange courseArrange) throws Exception {
        boolean conflict = this.haveConflict(courseArrange);
        if(!conflict){
            this.save(courseArrange);
            return true;
        }
        return false;
    }

    //对排课信息进行冲突检测，如发生冲突则返回有冲突的对象
    @Override
    public boolean haveConflict(CourseArrange courseArrange) throws Exception {
        //对教室安排进行检测
        CourseArrange classroomTest = this.getOne(new QueryWrapper<CourseArrange>()
                .select("*")
                .eq("classroom_no", courseArrange.getClassroomNo())
                .eq("week", courseArrange.getWeek())
                .eq("period", courseArrange.getPeriod())
        );
        if(classroomTest != null){
            throw new Exception("存在教室占用冲突，教室编号：" + classroomTest.getClassroomNo());
        }

        //对教师安排进行检测
        //通过授课编号，从授课表获得教师编号
        TeachCourse forTeacherNo = teachCourseService.getOne(new QueryWrapper<TeachCourse>()
                .select("teacher_no")
                .eq("teach_course_no", courseArrange.getTeachCourseNo())
        );
        //通过教师编号，从授课表获得该教师所有授课编号
        List<TeachCourse> teachCourseNoList = teachCourseService.list(new QueryWrapper<TeachCourse>()
                .select("teach_course_no")
                .eq("teacher_no", forTeacherNo.getTeacherNo())
        );
        //遍历授课编号列表，查询排课，若出现与当前排课相同安排则为冲突
        for(TeachCourse teachCourseNo : teachCourseNoList){
            CourseArrange teacherTest = this.getOne(new QueryWrapper<CourseArrange>()
                    .select("*")
                    .eq("teach_course_no", teachCourseNo.getTeachCourseNo())
                    .eq("week", courseArrange.getWeek())
                    .eq("period", courseArrange.getPeriod())
            );
            if(teacherTest != null) {
                throw new Exception("存在教师安排冲突，教师编号：" + forTeacherNo.getTeacherNo());
            }
        }

        //对班级安排进行检测
        //通过授课编号，从授课表获得班级编号
        TeachCourse forClazzNo = teachCourseService.getOne(new QueryWrapper<TeachCourse>()
                .select("clazz_no")
                .eq("teach_course_no", courseArrange.getTeachCourseNo())
        );
        //通过班级编号，从授课表获得该班级所有授课编号
        List<TeachCourse> forTeachCourseNoList2 = teachCourseService.list(new QueryWrapper<TeachCourse>()
                .select("teach_course_no")
                .eq("clazz_no", forClazzNo.getClazzNo())
        );
        //遍历授课编号列表，查询排课，若出现与当前排课相同安排则为冲突
        for(TeachCourse forTeachCourseNo : forTeachCourseNoList2){
            CourseArrange clazzTest = this.getOne(new QueryWrapper<CourseArrange>()
                    .select("*")
                    .eq("teach_course_no", forTeachCourseNo.getTeachCourseNo())
                    .eq("week", courseArrange.getWeek())
                    .eq("period", courseArrange.getPeriod())
            );
            if(clazzTest != null){
                throw new Exception("存在班级安排冲突，班级编号：" + forClazzNo.getClazzNo());
            }
        }

        return false;
    }
}
