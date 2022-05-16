package com.course.exception;


import com.course.result.CodeMsg;
import com.course.vo.UserVO;
import lombok.Data;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2022/4/17
 **/
@Data
public class LoginException extends GlobalException {

    private static final long serialVersionUID = 21L;

    private UserVO userVo;

    public LoginException(CodeMsg codeMsg, UserVO userVo) {
        super(codeMsg);
        this.userVo = userVo;
    }

    public LoginException(CodeMsg codeMsg) {
        super(codeMsg);
    }
}
