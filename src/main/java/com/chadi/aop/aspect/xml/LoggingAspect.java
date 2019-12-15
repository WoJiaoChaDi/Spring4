package com.chadi.aop.aspect.xml;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//基于xml配置切面
public class LoggingAspect {

    public void beforeMethod(JoinPoint joinPoint){

        //方法名
        String methodName = joinPoint.getSignature().getName();
        //参数
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        System.out.println("Begins --> Aspect: The Method Begins...");
        System.out.println("Begins --> MethodName: " + methodName);
        System.out.println("Begins --> Args: " + args);
    }

    public void afterMethod(JoinPoint joinPoint){

        //方法名
        String methodName = joinPoint.getSignature().getName();
        //参数
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        System.out.println("After --> Aspect: The Method After...");
        System.out.println("After --> MethodName: " + methodName);
        System.out.println("After --> Args: " + args);
    }

    public void returnMethod(JoinPoint joinPoint, Object result){

        //方法名
        String methodName = joinPoint.getSignature().getName();
        //参数
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        System.out.println("ReturnMethod --> Aspect: The Method ReturnMethod...");
        System.out.println("ReturnMethod --> MethodName: " + methodName);
        System.out.println("ReturnMethod --> Args: " + args);
        System.out.println("ReturnMethod --> result: " + result);
    }

    public void throwingMethod(JoinPoint joinPoint, ArithmeticException ex){//只有算数异常的时候才通知

        //方法名
        String methodName = joinPoint.getSignature().getName();
        //参数
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        System.out.println("AfterThrowingMethod --> Aspect: The Method AfterThrowing...");
        System.out.println("AfterThrowingMethod --> MethodName: " + methodName);
        System.out.println("AfterThrowingMethod --> Args: " + args);
        System.out.println("AfterThrowingMethod --> Exception: " + ex.getMessage());
    }

    public Object throwingMethod(ProceedingJoinPoint pjd){

        Object result = null;
        String methodName = pjd.getSignature().getName();
        List<Object> args = Arrays.asList(pjd.getArgs());

        System.out.println("AroundMethod --> Aspect: The Method Around...");
        System.out.println("AroundMethod --> MethodName: " + methodName);
        System.out.println("AroundMethod --> Args: " + args);

        try {
            //前置通知
            System.out.println("AroundMethod --> Aspect: The Method Before...");

            //执行方法
            result = pjd.proceed();

            //返回通知
            System.out.println("AroundMethod --> Aspect: The Method AfterReturning...");
        }catch (Throwable e){

            //异常通知
            System.out.println("AroundMethod --> Aspect: The Method AfterThrowing...");
            throw new RuntimeException(e);
        }finally {

            //后置通知
            System.out.println("AroundMethod --> Aspect: The Method After...");
        }
        return result;
    }

}
