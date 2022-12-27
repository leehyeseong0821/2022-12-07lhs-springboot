package com.study.springboot202212lhs.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAop {

    @Pointcut("execution(* com.study.springboot202212lhs.controller.AccountApiController.*(..))")
    private void executionPointCut(){}

    @Around("executionPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    Object[] args = proceedingJoinPoint.getArgs();

    for (Object arg : args){
        System.out.println(arg);
    }

    return proceedingJoinPoint.proceed();
    }
}
