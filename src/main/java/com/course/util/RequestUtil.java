package com.course.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Describe: Cookie工具类
 * @Author: tyf
 * @CreateTime: 2022/4/21
 **/
public class RequestUtil {
    /**
     * 获取对应的用户Cookie值
     *
     * @param request
     * @param cookieName
     * @return 值
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length <= 0) return null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }

}