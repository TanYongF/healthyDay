package com.course.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author lixuy
 * Created on 2019-04-10
 */
public class ScoreMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("before method invoke....");
        Object object = methodInvocation.proceed();
        try {
            String controllerName = methodInvocation.getThis().getClass().getSimpleName();
            String serviceName = "com.course.service." + controllerName;

            Class service = Class.forName(serviceName);
            Object serviceObject = service.newInstance();
            Method method = service.getMethod(methodInvocation.getMethod().getName());
            if (method != null) {
                method.invoke(serviceObject);
            }
        } catch (ClassNotFoundException  e) {
            e.printStackTrace();
        }
        System.out.println("after method invoke.....");
        return object;
    }
}
