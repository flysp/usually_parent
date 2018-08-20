package com.jxedu.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener("helloListener")
public class HelloListener  implements ServletRequestAttributeListener{

       private  static  final   Logger logger = LoggerFactory.getLogger(HelloListener.class);

    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {

        String name = servletRequestAttributeEvent.getName();
        Object value = servletRequestAttributeEvent.getValue();

        logger.info("属性{}添加：{}",name,value);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {

        Object value = servletRequestAttributeEvent.getValue();
        String name = servletRequestAttributeEvent.getName();

        logger.info("属性{}删除：{}",name,value);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {

        String name = servletRequestAttributeEvent.getName();
        Object value = servletRequestAttributeEvent.getValue();

        logger.info("属性{},替换{}",name,value);
    }
}