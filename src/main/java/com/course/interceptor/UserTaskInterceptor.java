package com.course.interceptor;

import com.course.interceptor.strategy.IUserTaskStrategy;
import com.course.interceptor.strategy.LoginStrategy;
import com.course.interceptor.strategy.UserTaskStrategyType;
import com.course.pojo.User;
import com.course.service.UserService;
import com.course.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Describe: 用户任务拦截器，主要通过userTaskStrategyMap来维护不同的积分策略
 * @Author: tyf
 * @CreateTime: 2022/5/12
 **/
@Component
public class UserTaskInterceptor implements HandlerInterceptor{

    private Map<String, IUserTaskStrategy> userTaskStrategyMap = new HashMap<>();

    @Autowired
    UserService userService;

    @Autowired
    LoginStrategy loginUserTaskStrategy;


    /**
     * 生成对应 Map
     * @param iUserTaskStrategies
     */
    @Autowired
    public void setUserTaskStrategyMap(List<IUserTaskStrategy> iUserTaskStrategies){
        iUserTaskStrategies.forEach(iUserTaskStrategy -> {
            String[] uris = Objects.requireNonNull(AnnotationUtils.findAnnotation(iUserTaskStrategy.getClass(),
                    UserTaskStrategyType.class).uri());
            userTaskStrategyMap.putAll(Arrays.stream(uris).collect(Collectors.toMap(uri->uri, uri-> iUserTaskStrategy)));
        });
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String uri = request.getRequestURI();
        String token = RequestUtil.getTokenByRequest(request);
        User user = userService.getByToken(response, token);
        //每个接口都可以使用每日登陆积分策略拦截器
        loginUserTaskStrategy.finishedUserIntegralTask(user, token, request);
        //获取对应的积分策略拦截器
        IUserTaskStrategy userStrategy = userTaskStrategyMap.get(uri);
        //其他接口过滤器
        if (userStrategy != null) {
            userStrategy.finishedUserIntegralTask(user, token, request);
        }
    }

}
