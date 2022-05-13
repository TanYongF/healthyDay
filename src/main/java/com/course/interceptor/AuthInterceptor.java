package com.course.interceptor;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.course.result.CodeMsg;
import com.course.service.UserService;
import com.course.util.RequestUtil;
import com.course.validator.NeedAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Describe: 鉴权模块
 * @Author: tyf
 * @CreateTime: 2022/4/21
 **/
@Component
public class AuthInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取注解
        boolean hasAuth;
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        NeedAuth access = handlerMethod.getMethod().getAnnotation(NeedAuth.class);
        //如果未标记注解，直接返回空 直接放行
        if (access == null) {
            return true;
        }
        String paramToken = request.getParameter(UserService.COOKIE_NAME_TOKEN);
        String cookieToken = RequestUtil.getCookieValue(request, UserService.COOKIE_NAME_TOKEN);
        //token为空，那么该用户未登录，返回null
        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            hasAuth = false;
        } else {
            String token = paramToken == null ? cookieToken : paramToken;
            hasAuth = userService.isAuth(token);
        }
        if (!hasAuth) {
            logger.error("用户请求被拦截");
            response.reset();
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JSON.toJSON(CodeMsg.SESSION_ERROR).toString());
        }
        return hasAuth;
    }

}
