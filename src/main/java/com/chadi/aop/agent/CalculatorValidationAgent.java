package com.chadi.aop.agent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculatorValidationAgent implements InvocationHandler {

    private Log log = LogFactory.getLog(this.getClass());

    private Object target;

    public CalculatorValidationAgent(Object target){
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("The Method" + method.getName() + "() begins with " + Arrays.toString(args));

        //验证数据
        for(Object arg : args){
            validate((Integer) arg);
        }

        //调用原方法
        Object result = method.invoke(target, args);

        log.info("The Method" + method.getName() + "() ends with " + result);
        return result;
    }

    public static Object createProxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new CalculatorValidationAgent(target));
    }

    private void validate(int a){
        if(a < 0){
            throw new IllegalArgumentException("Positive numbers only");
        }
    }
}
