package com.graduation.demo.common;

import com.graduation.demo.utils.DataResult;

/**
 * 数据字典类
 */
public class Constant {
    public static Integer USER_TYPE_ADMIN = 1;
    public static Integer USER_TYPE_TEACHER = 2;
    public static Integer USER_TYPE_STUDENT = 3;

    public static char MENU_TYPE_MENU = 'M';
    public static char MENU_TYPE_CONTROLLER = 'C';
    public static char MENU_TYPE_FUNC = 'F';

    public static DataResult ADD_SUCCESS = DataResult.getResult(0, "添加成功");
    public static DataResult ADD_ERROR = DataResult.getResult(401, "添加失败");

    public static DataResult UPDATE_SUCCESS = DataResult.getResult(0, "修改成功");
    public static DataResult UPDATE_ERROR = DataResult.getResult(401, "修改失败");

    public static DataResult DELETE_SUCCESS = DataResult.getResult(0, "删除成功");
    public static DataResult DELETE_ERROR = DataResult.getResult(401, "删除失败");
}
