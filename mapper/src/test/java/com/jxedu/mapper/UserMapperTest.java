package com.jxedu.mapper;

import com.jxedu.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-mapper.xml"})
public class UserMapperTest {

      @Resource
       private UserMapper userMapper;

      @Resource
      private UserMapp2 userMapp2;

    private static  final Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

      @Test
     public void testlist(){

          List<User> users = userMapper.selectAll();

          logger.info("返回的信息是:"+users);

      }

      @Test
      public void testuser(){

          User user = userMapper.getUserById(1L);
          logger.info("返回的单个用户信息：{}",user);
      }

      @Test
      public void testuser2(){

          User user = userMapper.getUserById2(1L);

          logger.info("返回的单个用户信息：{}",user);
      }

      @Test
      public void testMymapper(){

          List<User> users = userMapp2.select(null);

          logger.info("自定义的返回的全部信息：{}",users);

      }

      @Test
      public void testinsertBatch(){

          ArrayList<User> users = new ArrayList<>();

          Stream.iterate(1,(x) -> x+1).limit(5).forEach((xx) ->{

              User user = new User();
                 user.setName("sdfas"+xx);
               users.add(user);
          });

           userMapper.batch(users);
      }

    @Test
    public void testinsertBatch2(){

        ArrayList<User> users = new ArrayList<>();

        Stream.iterate(1,(x) -> x+1).limit(5).forEach((xx) ->{

            User user = new User();
            user.setName("tyughjf"+xx);
            users.add(user);
        });

        userMapp2.insertBatch(users);
    }

      @Test
    public void test01(){}
}
