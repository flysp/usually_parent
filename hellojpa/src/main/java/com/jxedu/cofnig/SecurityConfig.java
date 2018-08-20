package com.jxedu.cofnig;

import com.jxedu.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 创建过滤器
 */
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){

        return  new BCryptPasswordEncoder();
    }

    /**
     * configureGlobal 方法名无关紧要  重要的是注入 AuthenticationManagerBuilder。
     * @param auth
     * @throws Exception
     *
     * 1、访问应用中的每个URL都需要进行验证
     *
     * 2、生成一个登陆表单
     *
     * 3、允许用户使用username和password来登陆
     *
     * 4、允许用户注销
     *
     * 5、CSRF攻击拦截
     *
     * 6、 Session Fixation攻击
     *
     * 7、 安全Header集成
     */

    /**
     * 在内存中添加用户
     * @param auth
     * @throws Exception
     */
   /* @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/index.html").permitAll()//访问index.html不要权限验证
                .anyRequest().authenticated()//其他所有路径都需要权限校验
                .and()
             /*   .regexMatcher("")
                .authorizeRequests()
                .and()*/
                .csrf().disable()//默认开启，这里先显式关闭
                .formLogin()  //内部注册 UsernamePasswordAuthenticationFilter
                .loginPage("/login.html") //表单登录页面地址
                .loginProcessingUrl("/login")//form表单POST请求url提交地址，默认为/login
                .passwordParameter("password")//form表单用户名参数名
                .usernameParameter("username") //form表单密码参数名
                .successForwardUrl("/success.html")  //登录成功跳转地址
                .failureForwardUrl("/error.html") //登录失败跳转地址
                //.defaultSuccessUrl()//如果用户没有访问受保护的页面，默认跳转到页面
                //.failureUrl()
                //.failureHandler(AuthenticationFailureHandler)
                //.successHandler(AuthenticationSuccessHandler)
                //.failureUrl("/login?error")
                .permitAll();//允许所有用户都有权限访问登录页面
    }
}
