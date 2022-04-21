package com.graduation.demo.common;

import com.graduation.demo.entity.base.Admin;
import com.graduation.demo.entity.base.Student;
import com.graduation.demo.entity.base.Teacher;

import java.util.List;

/**
 * 用户活动类
 */
public class ActiveUser {
    int roleType;
    Admin admin;
    Teacher teacher;
    Student student;
    List<String> permissions;

    public ActiveUser() {
    }

    public ActiveUser(Admin admin, List<String> permissions) {
        this.roleType = 1;
        this.admin = admin;
        this.permissions = permissions;
    }

    public ActiveUser(Teacher teacher, List<String> permissions) {
        this.roleType = 2;
        this.teacher = teacher;
        this.permissions = permissions;
    }

    public ActiveUser(Student student, List<String> permissions) {
        this.roleType = 3;
        this.student = student;
        this.permissions = permissions;
    }

    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int roleType) {
        this.roleType = roleType;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
