package com.graduation.demo.entity.base;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 王奥
 * @since 2022-04-12
 */
@TableName("xk_classroom")
public class Classroom implements Serializable {

private static final long serialVersionUID=1L;


    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @ApiModelProperty(value = "教室编号")
    private String classroomNo;

    @ApiModelProperty(value = "教室名称")
    private String name;

    @ApiModelProperty(value = "教室类别，0为普通，1为特殊")
    private Integer classroomType;

    @ApiModelProperty(value = "所在教学楼")
    private String build;

    @ApiModelProperty(value = "描述")
    private String description;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassroomNo() {
        return classroomNo;
    }

    public void setClassroomNo(String classroomNo) {
        this.classroomNo = classroomNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClassroomType() {
        return classroomType;
    }

    public void setClassroomType(Integer classroomType) {
        this.classroomType = classroomType;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Classroom{" +
        "id=" + id +
        ", classroomNo=" + classroomNo +
        ", name=" + name +
        ", classroomType=" + classroomType +
        ", build=" + build +
        ", description=" + description +
        "}";
    }
}
