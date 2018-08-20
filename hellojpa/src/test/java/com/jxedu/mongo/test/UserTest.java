package com.jxedu.mongo.test;

import com.jxedu.entity.Person;
import com.jxedu.entity.UserMong;
import com.jxedu.mongo.UserMogoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-jpa.xml","classpath*:applicationContext-mongo.xml"})
public class UserTest {

    @Resource
     private MongoTemplate mongoTemplate;

    @Resource
    private UserMogoDao userMogoDao;

    private static  final   Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Test
    public void test01(){

         logger.debug("mongoTemplae 信息{}",mongoTemplate );
    }

    @Test
    public void test2(){

        Person person  = new Person();
        person.setName("lsdf");
        person.setAddress("佛山");
        person.setAge(23);
        person.setJob("java开发");
       person.setPersonId(1L);
        mongoTemplate.insert(person);
        logger.info("保存成功.......");
    }
    @Test
    public void test2save(){

        UserMong person  = new UserMong();
        person.setName("lsdf");
        person.setAddress("佛山");
        UserMong save = userMogoDao.save(person);
        logger.info("保存成功.......person:{}",save);
    }

    @Test
    public void testsleect(){

    }
    @Test
    public void test3(){

        List<Person> pers = mongoTemplate.findAll(Person.class);

         logger.info("******************************");
        logger.info("返回的全部用户信息：{}",pers);
        logger.info("******************************");

    }

    @Test
    public void test4(){

        List<UserMong> personList = userMogoDao.findAll();

        logger.info("******************************");
        logger.info("userMongoDao返回的全部用户信息：{}",personList);
        logger.info("******************************");

    }

    @Test
    public void test5(){

        UserMong per = userMogoDao.findOne("5b4df15b012fcf167df95813");

        logger.info("******************************");
        logger.info("userMongoDao返回的23L用户信息：{}",per);
        logger.info("******************************");
    }


    @Test
    public void test6(){

        UserMong person = new UserMong();
        Example<UserMong> per = Example.of(person);

        List<UserMong> personList = userMogoDao.findAll(per);

        logger.info("******************************");
        logger.info("userMongoDao返回的全部用户信息：{}",personList);
        logger.info("******************************");
    }

    @Test
    public void testdelete(){

          userMogoDao.deleteAll();
    }
}
