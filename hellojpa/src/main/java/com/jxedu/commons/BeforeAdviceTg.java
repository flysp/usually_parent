package com.jxedu.commons;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeAdviceTg implements MethodBeforeAdvice {


    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        System.out.println("前置。。。。。剪辑");
        method.invoke(target,args);

    }
}
