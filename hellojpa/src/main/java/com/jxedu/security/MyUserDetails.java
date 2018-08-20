package com.jxedu.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


//@Component
public class MyUserDetails implements UserDetailsService {

     @Autowired
      private PasswordEncoder passwordEncoder;


    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


      logger.info("当前的用户名{}",s);

        //return  new User(s,passwordEncoder.encode("1234"),AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));

        return new User(s,passwordEncoder.encode("1234"),true,true,true,true,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
