package com.chao.controller;

import com.chao.common.Result;
import com.chao.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author Eliot
 */
@Slf4j
@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){

        //账号名重复情况
        if (ex.getMessage().contains("Duplicate entry")) {
            String[] split = ex.getMessage().split(" ");
            String msg = split[2]+"已存在";
            return Result.error(msg);
        }

        return Result.error("未知错误");
    }

    @ExceptionHandler(BusinessException.class)
    public Result<String> businessExceptionHandler(BusinessException ex){
        return Result.error(ex.getMessage());
    }
}











