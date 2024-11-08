package com.chao.exception;

/**
 * 系统异常---自定义处理异常
 * @author Eliot
 */
public class SystemException extends RuntimeException{
    private Integer code;


    public SystemException( Integer code,String message) {
        super(message);
        this.code = code;
    }

    public SystemException( Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
