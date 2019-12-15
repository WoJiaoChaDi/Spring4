package com.atguigu.spring.beans.autowire;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanNamme) throws BeansException {
        System.out.println("postProcessBeforeInitialization..." + beanNamme + ", " + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanNamme) throws BeansException {
        System.out.println("postProcessAfterInitialization..." + beanNamme + ", " + bean);
        return bean;
    }
}
