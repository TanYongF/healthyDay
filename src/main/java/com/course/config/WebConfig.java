package com.course.config;

import com.course.interceptor.AuthInterceptor;
import com.course.interceptor.UserTaskInterceptor;
import com.course.interceptor.strategy.IUserTaskStrategy;
import com.course.interceptor.strategy.UserTaskStrategyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Describe: web全局配置类
 * @Author: tyf
 * @CreateTime: 2022/4/17
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private UserArgumentResolver userArgumentResolver;
    @Autowired
    private AuthInterceptor authInterceptor;
    private List<String> uriList = new ArrayList<>();
    @Autowired
    private UserTaskInterceptor userTaskInterceptor;


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        //注入自定义的解析器
        argumentResolvers.add(userArgumentResolver);
    }

    @Autowired
    public void setUriList(List<IUserTaskStrategy> iUserTaskStrategies){
        iUserTaskStrategies.forEach(iUserTaskStrategy -> {
            String[] uris = Objects.requireNonNull(AnnotationUtils.findAnnotation(iUserTaskStrategy.getClass(),
                    UserTaskStrategyType.class).uri());
            uriList.addAll(Arrays.asList(uris));
        });
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userTaskInterceptor).addPathPatterns(uriList).excludePathPatterns("/login/**");
        registry.addInterceptor(authInterceptor).addPathPatterns("/brs/**", "/inr/**", "/u/**");
    }
}
