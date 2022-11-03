package com.course.util;

import cn.hutool.json.JSONArray;
import com.course.pojo.Activity;

import java.util.List;

/**
 * @Describe: Json转换工具类
 * @Author: tyf
 * @CreateTime: 2022/4/24
 **/
public class JSONUtil {

    /**
     * JavaObject to JsonString
     *
     * @param value:Java对象
     * @param <T>:
     * @return：Json字符串
     */
    public static <T> String beanToString(T value) {
        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else if (clazz == byte.class || clazz == Byte.class) {
            return value.toString();
        } else {
            return cn.hutool.json.JSONUtil.toJsonStr(value);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T stringToBean(String str, Class<T> clazz) {
        if (str == null || str.length() <= 0 || clazz == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(str);
        } else if (clazz == String.class) {
            return (T) str;
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(str);
        } else if (clazz == byte.class || clazz == Byte.class) {
            return (T) Byte.valueOf(str);
        } else if (clazz == List.class){
            JSONArray objects = cn.hutool.json.JSONUtil.parseArray(str);
            return (T) cn.hutool.json.JSONUtil.toList(objects, Activity.class);
        }else{
            return cn.hutool.json.JSONUtil.toBean(str, clazz);
        }
    }
}
