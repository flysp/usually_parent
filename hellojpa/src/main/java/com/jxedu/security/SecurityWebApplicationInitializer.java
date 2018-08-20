package com.jxedu.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * 注册 springSecurityFilterChain
 * 这个可以借助Spring3.1引入的WebApplicationInitializer完成。SpringSecurity提供了一个基类 AbstractSecurityWebApplicationInitializer来确保 springSecurityFilterChain被注册。
 */
public class SecurityWebApplicationInitializer /*extends AbstractSecurityWebApplicationInitializer */{

    /**
     * 如果没有使用Spring或者SpringMvc，你需要传递我们的 SecurityConfig类到父类中，从而确保我们的配置会被加载
     *
     * 如果使用的环境已经有spring了还使用下面的代码则会报错，所以需要注释掉掉
     *
     * SecurityWebApplicationInitializer将会做以下的事情:
     *
     * 自动注册 springSecurityFilterChain 过滤器，并作用于应用中的每个URL。
     *
     * 添加一个 ContextLoaderListener 来加载 SecurityConfig类。
     */
  /*  public SecurityWebApplicationInitializer() {
        super(SecurityConfig.class);
    }*/




}
