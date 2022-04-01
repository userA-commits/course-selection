package com.graduation.demo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.graduation.demo.entity.Course;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 教师带课程实体（一对多）
 *
 * @author 王奥
 * @since 2022-04-02
 */
@ApiModel("教师带课程实体")
public class TeacherWithCourse implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "tid", type = IdType.AUTO)
    @ApiModelProperty(name = "教师ID", dataType = "String")
    private String tid;
    @ApiModelProperty(name = "教师名", dataType = "String")
    private String tname;
    @ApiModelProperty(name = "性别", dataType = "Int")
    private Integer sex;
    @ApiModelProperty(name = "职称", dataType = "String")
    private String title;
    @ApiModelProperty(name = "密码", dataType = "String")
    private String password;
    @ApiModelProperty(name = "课程列表", dataType = "List<Course>")
    private List<Course> courses;

    @Override
    public String toString() {
        return "TeacherWithCourse{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", sex=" + sex +
                ", title='" + title + '\'' +
                ", password='" + password + '\'' +
                ", courses=" + courses +
                '}';
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
