package com.graduation.demo.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *  获取Web系统类
 *
 * @author 王奥
 * @since 2022-04-19
 */
public class WEBUtils {
    //得到request
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request;
    }
    //得到session
    public static HttpSession getSession(){
        return getRequest().getSession();
    }
}
