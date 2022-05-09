package com.course.exception;


import com.course.result.CodeMsg;
import com.course.vo.LoginVo;
import lombok.Data;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2022/4/17
 **/
@Data
public class LoginException extends GlobalException {

    private static final long serialVersionUID = 21L;

    private LoginVo loginVo;

    public LoginException(CodeMsg codeMsg, LoginVo loginVo) {
        super(codeMsg);
        this.loginVo = loginVo;
    }

    public LoginException(CodeMsg codeMsg) {
        super(codeMsg);
    }
}
