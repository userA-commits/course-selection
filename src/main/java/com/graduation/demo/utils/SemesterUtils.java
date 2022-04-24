package com.graduation.demo.utils;

import java.util.Calendar;

public class SemesterUtils {
    public static Integer getSemester(int grade){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int ySemester = (year - grade) * 2;
        if(month >= 7) return ySemester + 1;
        else return ySemester;
    }
}
