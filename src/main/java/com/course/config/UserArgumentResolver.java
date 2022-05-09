package com.course.config;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 具体作用是将每次请求传入的user信息（auth）,进行判定是否已登录，
 * 如果已经登陆，获取用户token并将其token过期时间更新
 * 如果未登录，返回null
 *
 * @Describe: 用户参数解析器
 * @Author: tyf
 * @CreateTime: 2022/4/17
 **/
@Service
public class UserArgumentResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return null;
    }
}
