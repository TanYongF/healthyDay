package com.course.exception;


import com.course.result.CodeMsg;
import com.course.vo.UserVo;
import lombok.Data;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2022/4/17
 **/
@Data
public class LoginException extends GlobalException {

    private static final long serialVersionUID = 21L;

    private UserVo userVo;

    public LoginException(CodeMsg codeMsg, UserVo userVo) {
        super(codeMsg);
        this.userVo = userVo;
    }

    public LoginException(CodeMsg codeMsg) {
        super(codeMsg);
    }
}
