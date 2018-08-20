package com.jxedu.test;

import com.jxedu.bean.User;
import com.jxedu.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-plus.xml"})
public class HelloTest {

    private static  final Logger logger = LoggerFactory.getLogger(HelloTest.class);

      @Autowired
       private UserMapper userMapper;
       @Test
     public void  test01(){

           User user = new User();

           List<User> users = user.selectAll();

             logger.info("返回的信息：{}",users);
       }

       @Test
    public void testo2(){

           List<User> users = userMapper.selectList(null);

           logger.info("返回的信息：{}",users);
       }
}
