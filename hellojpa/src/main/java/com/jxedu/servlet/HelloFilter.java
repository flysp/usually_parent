package com.jxedu.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@WebFilter(filterName = "helloFilter",urlPatterns = {"/*"})
public class HelloFilter  implements Filter {

      private  static  final  Logger logger = LoggerFactory.getLogger(HelloFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

           logger.info("HelloFilter......初始化了.......");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

            logger.info("过滤。。。。。");
           HttpServletRequest  request  = (HttpServletRequest) servletRequest;

        Map<String, String[]> parameterMap = request.getParameterMap();

            parameterMap.forEach((K,V) ->{logger.info("key:{},====value:{}",K,V);});

        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {

          logger.info("HelloFilter....销毁了.....");
    }
}
