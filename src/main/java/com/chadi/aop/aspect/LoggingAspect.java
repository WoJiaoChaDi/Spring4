package com.chadi.aop.aspect;


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

@Aspect
@Component
public class LoggingAspect {

    //切面为ArithmeticCalculator类的add方法
    //@Before("execution(public void com.chadi.aop.agent.ArithmeticCalculator.add(int, int ))")

    //切面为ArithmeticCalculator类的所有方法
    //前置通知
    @Before("execution(public void com.chadi.aop.agent.ArithmeticCalculator.*(int, int ))")
    @Order(0)
    public void beforeMethod(JoinPoint joinPoint){

        //方法名
        String methodName = joinPoint.getSignature().getName();
        //参数
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        System.out.println("Begins --> Aspect: The Method Begins...");
        System.out.println("Begins --> MethodName: " + methodName);
        System.out.println("Begins --> Args: " + args);
    }

    //合并切入点表达式
    @Pointcut("execution(public void com.chadi.aop.agent.ArithmeticCalculator.add(int, int )) || execution(public void com.chadi.aop.agent.ArithmeticCalculator.sub(int, int ))")
    public void afterMethodPointCut(){};

    //后置通知
    @After("afterMethodPointCut()")
    public void afterMethod(JoinPoint joinPoint){

        //方法名
        String methodName = joinPoint.getSignature().getName();
        //参数
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        System.out.println("After --> Aspect: The Method After...");
        System.out.println("After --> MethodName: " + methodName);
        System.out.println("After --> Args: " + args);
    }

    //返回通知
    @AfterReturning(value = "execution(public void com.chadi.aop.agent.ArithmeticCalculator.*(int, int ))()",
                    returning = "result")
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

    //异常通知
    @AfterThrowing(value = "execution(public void com.chadi.aop.agent.ArithmeticCalculator.*(int, int ))()",
            throwing = "ex")
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

    /*
    环绕通知
    环绕通知需要携带ProceedingJoinPoint 类型的参数
    环绕通知类似于动态代理的全过程： ProceedingJoinPoing 类型的参数可以决定是否执行目标方法
    且环绕通知必须有返回值，返回值为目标方法的返回值
    */
    @Around(value = "execution(public void com.chadi.aop.agent.ArithmeticCalculator.*(int, int ))()")
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
