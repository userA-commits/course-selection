package com.graduation.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 王奥
 * @since 2022-03-11
 */
@ApiModel("教师实体")
public class Teacher implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "tid", type = IdType.AUTO)
    @ApiModelProperty(name = "教师ID", dataType = "String")
    private String tid;
    @ApiModelProperty(name = "教师名", dataType = "String")
    private String tname;
    @ApiModelProperty(name = "性别", dataType = "String")
    private Integer sex;
    @ApiModelProperty(name = "职称", dataType = "String")
    private String title;


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

    @Override
    public String toString() {
        return "Teacher{" +
        "tid=" + tid +
        ", tname=" + tname +
        ", sex=" + sex +
        ", title=" + title +
        "}";
    }
}
