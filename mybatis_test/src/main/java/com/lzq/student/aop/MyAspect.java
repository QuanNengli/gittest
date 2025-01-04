package com.lzq.student.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyAspect {
    @Pointcut("execution(* com.lzq.student.aop.AopService.* (..))")
    public void pointcut(){

    }
    @Before("pointcut()")
    public void advice(JoinPoint joinPoint){
        System.out.println("前置通知");
        System.out.println(joinPoint.getTarget().toString());
    }
    @AfterReturning("pointcut()")
    public void afterReturnAdvice(){
        System.out.println("后置通知");
    }
    @Around("pointcut()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("前环绕");
        proceedingJoinPoint.proceed();
        System.out.println("后环绕");
    }
    @AfterThrowing("pointcut()")
    public void throwAdvice(){
        System.out.println("异常通知");
    }
    @After("pointcut()")
    public void afterAdvice(){
        System.out.println("最终通知");
    }
}
