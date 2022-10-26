package com.course.exception;

import com.course.result.CodeMsg;
import com.course.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Describe: 自定义异常全局处理器
 * @Author: tyf
 * @CreateTime: 2022/4/17
 **/
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        if (e instanceof BindException) {
            BindException ex = (BindException) e;
            List<ObjectError> allErrors = ex.getAllErrors();
            CodeMsg msg = CodeMsg.BIND_ERROR.fillArgs(allErrors.get(0).getDefaultMessage());
            return Result.error(msg);
        } else if (e instanceof LoginException) {
            LoginException le = (LoginException) e;
            return Result.error(((LoginException) e).getCodeMsg());
        } else if (e instanceof GlobalException) {
            logger.error(e.getMessage());
            return Result.error(((GlobalException) e).getCodeMsg());
        } else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

}
