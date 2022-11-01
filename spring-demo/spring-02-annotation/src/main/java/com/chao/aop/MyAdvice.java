package com.chao.aop;

import com.sun.beans.editors.ColorEditor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import sun.plugin2.util.ColorUtil;

import javax.annotation.PostConstruct;

/**
 * @author Eliot
 */

@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(* com.chao.service.*Service.*(..))")
    private void servicePt(){}

    @Pointcut("execution(boolean com.chao.service.*Service.*(String,String))")
    private void dataPt(){}

    @Around("servicePt()")
    public Object sqlRunningTime(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        String declaringTypeName = signature.getDeclaringTypeName();
        String name = signature.getName();

        long start = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        long end = System.currentTimeMillis();
        System.out.println(declaringTypeName+"."+name+"---->"+(end-start)/1000.+"s");
        return proceed;
    }

    @Around("dataPt()")
    public Object trimStr(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            if(args[i].getClass().equals(String.class)){
                args[i] = args[i].toString().trim();
            }
        }

        Object proceed = pjp.proceed(args);
        return proceed;
    }
}
