package com.all.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler
    public Result doException (Exception ex) {
        ex.printStackTrace();
        return new Result(false,"服务器故障,请稍后再试");
    }
}
