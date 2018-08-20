package com.jxedu.com.jxedu.aop;

import com.jxedu.commons.BeforeAdviceTg;
import com.jxedu.service.PersonProxyService;
import com.jxedu.service.PersonProxyServiceImpl;
import org.junit.Test;
import org.springframework.aop.aspectj.AspectJAopUtils;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.aop.aspectj.AspectJMethodBeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.DefaultAopProxyFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.test.util.AopTestUtils;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AOPTest {

      @Test
     public  void test01() throws IOException {

          byte[] proxy01s = ProxyGenerator.generateProxyClass("proxy01", new Class[]{PersonProxyService.class});

          Path path = new File("C:\\class\\proxy01.class").toPath();
          Files.write(path, proxy01s);


      }

      @Test
     public void test02(){

          AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(new PersonProxyServiceImpl());

          AspectJExpressionPointcutAdvisor aspectJExpressionPointcut = new AspectJExpressionPointcutAdvisor();

          BeforeAdviceTg beforeAdviceTg = new BeforeAdviceTg();
          aspectJExpressionPointcut.setExpression("execution(* *.info(..))");
          aspectJExpressionPointcut.setAdvice(beforeAdviceTg);

          aspectJProxyFactory.addAdvisor(aspectJExpressionPointcut);
          PersonProxyService  proxy = aspectJProxyFactory.getProxy();

          System.out.println(proxy.getClass());
          proxy.info();


      }

      @Test
    public void test03(){
          DefaultAopProxyFactory defaultAopProxyFactory = new DefaultAopProxyFactory();
          AdvisedSupport advisedSupport = new AdvisedSupport();


          DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
         defaultPointcutAdvisor.setAdvice(new BeforeAdviceTg());
          advisedSupport.addAdvisor(defaultPointcutAdvisor);
          advisedSupport.setTarget(new PersonProxyServiceImpl());
      //    advisedSupport.addAdvice(new BeforeAdviceTg());

          AopProxy aopProxy = defaultAopProxyFactory.createAopProxy(advisedSupport);


       ((PersonProxyService)aopProxy.getProxy()).info();



      }
}
