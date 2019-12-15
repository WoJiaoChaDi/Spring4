package com.atguigu.spring.beans.autowire;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor2 implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanNamme) throws BeansException {
        System.out.println("postProcessBeforeInitialization2..." + beanNamme + ", " + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanNamme) throws BeansException {
        System.out.println("postProcessAfterInitialization2..." + beanNamme + ", " + bean);
        return bean;
    }
}
