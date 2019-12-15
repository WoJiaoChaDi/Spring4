package com.chadi.aop.aspect.xml;

import com.chadi.aop.agent.ArithmeticCalculator;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//基于xml配置切面
public class TestAspect {

    @Test
    public void test1(){

        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext-Aspect-Xml.xml");

        ArithmeticCalculator arit = cxt.getBean(ArithmeticCalculator.class);
        //arit.add(1,2);
        //System.out.println("==========");
        //arit.sub(2,3);
        //System.out.println("==========");
        //arit.mul(2,3);
        arit.div(2,1);
    }
}
