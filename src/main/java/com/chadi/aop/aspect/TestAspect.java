package com.chadi.aop.aspect;

import com.chadi.aop.agent.ArithmeticCalculator;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspect {

    @Test
    public void test1(){

        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext-Aspect.xml");

        ArithmeticCalculator arit = cxt.getBean(ArithmeticCalculator.class);
        //arit.add(1,2);
        //System.out.println("==========");
        //arit.sub(2,3);
        //System.out.println("==========");
        //arit.mul(2,3);
        arit.div(2,1);
    }
}
