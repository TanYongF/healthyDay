package com.course.validator;

import com.alibaba.druid.util.StringUtils;
import com.course.util.ValidatorUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Describe: 手机号校验器
 * @Author: tyf
 * @CreateTime: 2022/4/16
 **/
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

    private boolean required = true;

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required) {
            return ValidatorUtil.isMobile(value);
        } else {
            if (StringUtils.isEmpty(value)) {
                return true;
            } else {
                return ValidatorUtil.isMobile(value);
            }
        }
    }
}
