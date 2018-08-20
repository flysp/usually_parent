package com.jxedu.mapper;

import com.jxedu.bean.Address;
import com.jxedu.bean.Person;
import com.jxedu.bean.Season;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-mapper.xml"})
public class PersonMapperTest {


      @Resource
      private PersonMapper personMapper;

       private static final  Logger logger = LoggerFactory.getLogger(PersonMapperTest.class);

      @Test
     public  void test01(){

          List<Person> persons = personMapper.selectAll();

          logger.info("返回的全部信息：{}",persons);
      }

      @Test
     public void test02(){

          Person person = new Person();
          Address address = new Address();
           address.setProvince("广东");
           address.setCity("佛山");
          address.setStreet("南海");
          person.setAddress(address);

          person.setPersonAge(23);
         // person.setUserJob("快递");
          person.setUserName("李子");
          int insert = personMapper.insert(person);

          logger.info("影响了{}行",insert);
      }
    @Test
    public void test03(){

        Person person = new Person();
        Address address = new Address();
        address.setProvince("广东");
        address.setCity("佛山");
        address.setStreet("南海");
        person.setAddress(address);

        person.setPersonAge(23);
         person.setSeason(Season.AUTUMUN);
        person.setUserName("李子");
        int insert = personMapper.insert(person);

        logger.info("影响了{}行",insert);
    }

    @Test
    public void test04(){
        Person person = new Person();
        person.setPersonId(7L);
        Person person1 = personMapper.selectOne(person);

        logger.info("查询的单个用户信息{}",person1);
        logger.info("枚举的值:{}",person1.getSeason().getValue());
       Person person2 = personMapper.selectOne(person);

        logger.info("查询的2单个用户信息{}",person1);
        logger.info("枚举的值:{}",person1.getSeason().getValue());
    }


     @Test
    public void test05(){

         Person person = new Person();
         person.setPersonId(7L);
         person.setSeason(Season.SUMMER);
         person.setUserName("iji89s");
         person.setPersonAge(23);
         Address address = new Address();
         address.setProvince("广0东");
         address.setCity("佛山");
         address.setStreet("南海");
         person.setAddress(address);

         personMapper.updateBatch(Arrays.asList(new Person[]{person}));

     }

}
