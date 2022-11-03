package com.course.interceptor;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.course.result.CodeMsg;
import com.course.result.Result;
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
 * @author tyf
 * @description 在参数解析器解析完成user对象之前，会对token进行前置判别，
 * 如果为空或者Session不存在当前token，那么就会返回未登陆信息。
 * 如果不为空，那么对该请求直接放行
 * @date 11:51 2022/5/15
 **/
@Component
public class AuthInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        CodeMsg errorCode = null;
        //获取注解
        boolean hasAuth;
        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        handler = new HandlerMethod();
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
            errorCode = CodeMsg.NO_LOGIN;
        } else {
            String token = paramToken == null ? cookieToken : paramToken;
            hasAuth = userService.isAuth(token);
            //用户携带token但是Session已经过期。
            if(!hasAuth){
                errorCode = CodeMsg.SESSION_ERROR;
            }
        }
        //TODO: 这里应该是后端抛出错误状态码 然后前端可以跳转到500 400界面
        //如果未验证，那么就会返回未登录。
        if (!hasAuth) {
            logger.error("用户请求被拦截");
            response.reset();
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JSON.toJSON(Result.error(errorCode)).toString());
        }
        return hasAuth;
    }

}
