package com.chao.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Eliot
 */
@Data
public class Result<T> implements Serializable {
    private Integer code;

    private String msg;

    private T data;

    public static <T> Result<T> success(T object){
        Result<T> result=new Result<T>();
        result.code=1;
        result.data=object;
        return result;
    }

    public static <T> Result<T> error(String msg){
        Result<T> result=new Result<T>();
        result.code=0;
        result.msg=msg;
        return result;
    }
}
