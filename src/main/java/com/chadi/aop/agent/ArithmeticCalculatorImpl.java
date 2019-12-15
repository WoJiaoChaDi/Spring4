package com.chadi.aop.agent;

import org.springframework.stereotype.Component;

@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator{

    public void add(int i, int j) {
        int result = i + j;
        System.out.println("Method add --> " + result);
    }

    public void sub(int i, int j) {
        int result = i - j;
        System.out.println("Method add --> " + result);
    }

    public void mul(int i, int j) {
        int result = i * j;
        System.out.println("Method add --> " + result);
    }

    public void div(int i, int j) {
        int result = i / j;
        System.out.println("Method add --> " + result);
    }
}
