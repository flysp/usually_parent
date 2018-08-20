package com.jxedu.test;

import com.jxedu.bean.User;
import com.jxedu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-plus.xml"})
public class TransactionTest {

       @Resource
    private  UserService userService;

    private  Logger logger = LoggerFactory.getLogger(TransactionTest.class);

       @Test
     public void testsave(){

           User user = new User();
           user.setName("transaction");
           userService.saveUser(user);

            logger.info("保存用户返回的信息id:{}",user.getId());
       }
}
