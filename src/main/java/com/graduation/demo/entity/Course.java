package com.graduation.demo.entity;

public class Course {
    private Integer cid;

    private Integer type;

    private Float credit;

    private Integer grade;

    private Integer major;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }
}