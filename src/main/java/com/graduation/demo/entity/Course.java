package com.graduation.demo.entity;

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
 * @since 2022-03-24
 */
public class Course implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "cid", type = IdType.AUTO)
    @ApiModelProperty(name = "课程ID", dataType = "String")
    private String cid;
    @ApiModelProperty(name = "教师ID", dataType = "String")
    private String tid;
    @ApiModelProperty(name = "课程名", dataType = "String")
    private String cname;
    @ApiModelProperty(name = "持续时间", dataType = "String")
    private String period;
    @ApiModelProperty(name = "学分", dataType = "Float")
    private Float credit;
    @ApiModelProperty(name = "专业", dataType = "String")
    private String major;
    @ApiModelProperty(name = "课程最大人数", dataType = "String")
    private Integer maximum;
    @ApiModelProperty(name = "备注", dataType = "String", allowEmptyValue = true)
    private String desc;


    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Course{" +
        "cid=" + cid +
        ", cname=" + cname +
        ", period=" + period +
        ", credit=" + credit +
        ", major=" + major +
        ", maximum=" + maximum +
        ", desc=" + desc +
        ", tid=" + tid +
        "}";
    }
}
