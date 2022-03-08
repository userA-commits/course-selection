package com.graduation.demo.entity;

public class Sc {
    private String sid;

    private String cid;

    private Integer score;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}