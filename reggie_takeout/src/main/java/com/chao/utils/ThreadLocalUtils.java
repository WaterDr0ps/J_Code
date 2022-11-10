package com.chao.utils;

/**
 * 基于ThreadLocal封装工具类，用户获取当前线程作用域内登陆用户的id <br/>
 * 网页每次的http请求都会创建一个线程，所以每个线程作用域唯一
 * @author Eliot
 */

public class ThreadLocalUtils {
    public static InheritableThreadLocal<Long> threadLocal = new InheritableThreadLocal<>();

    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    public static Long getCurrentId(){
        return threadLocal.get();
    }

    public static void remove(){
        threadLocal.remove();
    }
}
