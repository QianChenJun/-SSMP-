package com.teng.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    // 拦截所有的异常信息
    @ExceptionHandler(Exception.class) // 处理某个异常
    public Result doException(Exception e) {
        // 处理一些事情, 比如记录日志, 通知运维, 通知开发
        e.printStackTrace(); // 打印异常
        return new Result("系统错误, 请稍后再试！");
    }
}
