package com.chao.controller;

import com.chao.exception.BusinessException;
import com.chao.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * AOP思想 项目的异常处理器
 * @author Eliot
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {

    /**
     * AOP思想自定义异常统一抓异常
     * @param e 自定义的系统异常
     * @return 返回统一的封装数据
     */
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e){
        return new Result(e.getCode(),null,e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e){
        return new Result(e.getCode(),null,e.getMessage());
    }

    /**
     * 其他异常,最后才会走到这一步
     * @param e 异常大类
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        return new Result(Code.ELSE_ERR,null,"系统繁忙");
    }
}
