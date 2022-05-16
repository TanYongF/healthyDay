package com.course.vo;

import com.course.validator.IsMobile;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * @Describe: 用户登陆表单视图实体
 * @Author: tyf
 * @CreateTime: 2022/4/16
 **/
@Data
@ToString
public class UserVO {

    @NotEmpty
    @IsMobile
    private String mobile;

    @NotEmpty
    private String password;
}
