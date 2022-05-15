package com.course.interceptor.strategy;


import javax.annotation.security.RunAs;
import java.lang.annotation.*;


/**
 * @author tyf
 * @description 策略注解
 * @date 10:20 2022/5/12
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserTaskStrategyType {
    String[] uri();
}
