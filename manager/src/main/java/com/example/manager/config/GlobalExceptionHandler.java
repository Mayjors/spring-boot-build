package com.example.manager.config;

import com.example.util.result.ResultMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 * @author yuanjie
 * @date 2018/10/18 10:06
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultMessage jsonErrorHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) throws Exception {
        ResultMessage resultMessage = new ResultMessage();

        return resultMessage;
    }

}
