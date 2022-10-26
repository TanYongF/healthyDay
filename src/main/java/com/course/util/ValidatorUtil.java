package com.course.util;

import com.alibaba.druid.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2022/4/16
 **/
public class ValidatorUtil {

    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

    public static boolean isMobile(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        Matcher matcher = mobile_pattern.matcher(str);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isMobile("16712866996"));
        System.out.println(isMobile("12222"));
    }
}
