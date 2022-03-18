package com.graduation.demo.enums;


public enum LoginType {
    STUDENT("Student"), ADMIN("Admin"), TEACHER("Teacher");

    String type;

    private LoginType(String type){
        this.type = type;
    }
}
