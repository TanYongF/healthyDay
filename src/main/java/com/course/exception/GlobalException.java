package com.course.exception;

import com.course.result.CodeMsg;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Describe: 全局异常处理器
 * @Author: tyf
 * @CreateTime: 2022/4/17
 **/
@Data
@NoArgsConstructor
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }


}
