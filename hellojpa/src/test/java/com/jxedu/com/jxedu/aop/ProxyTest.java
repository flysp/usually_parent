package com.jxedu.com.jxedu.aop;

import com.jxedu.service.PersonProxyService;
import com.jxedu.service.PersonProxyServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Objects;

public class ProxyTest {

    private static final Logger logger = LoggerFactory.getLogger(ProxyTest.class);

    @Test
    public void test01() {

        PersonProxyServiceImpl personService = new PersonProxyServiceImpl();

        PersonProxyService bean = (PersonProxyService) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{PersonProxyService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = null;
                logger.info("前置通知.................");
                try {

                    invoke = method.invoke(personService, args);

                } catch (Exception e) {

                    logger.error("异常通知.................");
                }
                logger.info("后置通知........................");

                return invoke;
            }
        });

        bean.info();
        bean.info2();
        logger.info("代理对象：{}", bean.getClass());
    }

    @Test
    public void test02() {

        PersonProxyServiceImpl personProxyService = new PersonProxyServiceImpl();

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(PersonProxyServiceImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                logger.info("Object o===>{}", o.getClass());
                logger.info("Method method===>{}", method.getName());
                logger.info("Object[] objects===>{}", Arrays.toString(objects));
                logger.info("MethodProxy methodProxy===>{}", methodProxy.getSuperName());
                Object invoke = null;
                logger.info("前置通知.......");
                try {

                    invoke = methodProxy.invokeSuper(o, objects);

                } catch (Exception e) {

                    logger.info("异常通知........");
                }
                logger.info("后置通知........");

                return invoke;
            }
        });


        PersonProxyServiceImpl personProxyService2 = (PersonProxyServiceImpl) enhancer.create();

        personProxyService2.info();
        //     personProxyService.info2();
        logger.info("cglib代理的类:{}", personProxyService2.getClass());

    }
}
