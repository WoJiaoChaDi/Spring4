package com.chadi.aop.agent;

import org.junit.Test;

public class TestAgent {

    @Test
    public void test1(){
        ArithmeticCalculator arithmeticCalculatorImpl = new ArithmeticCalculatorImpl();

        //未使用代理
        arithmeticCalculatorImpl.add(1, 2);
        System.out.println("=========");

        //添加代理
        ArithmeticCalculator aritLogging = (ArithmeticCalculator) CalculatorLoggingAgent.createProxy(arithmeticCalculatorImpl);
        aritLogging.add(2, 3);
        System.out.println("=========");

        //可以添加多个代理
        //添加代理的顺序，就是代理执行的顺序
        ArithmeticCalculator aritLoggingAndValidation = (ArithmeticCalculator) CalculatorLoggingAgent.createProxy(
                                                        CalculatorValidationAgent.createProxy(arithmeticCalculatorImpl));
        aritLoggingAndValidation.mul(4, 5);
        System.out.println("=========");
    }
}
