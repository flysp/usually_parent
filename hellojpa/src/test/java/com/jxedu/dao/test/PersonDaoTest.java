package com.jxedu.dao.test;

import com.jxedu.dao.PersonDao;
import com.jxedu.dao.SpecificationFactory;
import com.jxedu.entity.Pe;
import com.jxedu.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@ContextHierarchy(value = {
        @ContextConfiguration(locations = {"classpath:applicationContext-jpa.xml"})
})
@TestPropertySource(locations = {"classpath:hello.properties"})
public class PersonDaoTest {

      @Value("${hello.name}")
      private String name;

      @Value("${hello.address}")
      private String address;

      @Value("${hello.age}")
      private Integer age;

      @Test
      public void testproperties(){

           logger.debug("名字：{}-->地址：{}-->年代：{}",name,address,age);
      }


          @Autowired
          private PersonDao personDao;

    private static  Logger logger = LoggerFactory.getLogger(PersonDaoTest.class);

          @Test
         public void testPerson(){

              personDao.getPersons().forEach(System.out::println);
         //     personDao.findAll().forEach(System.out::println);
          }


          @Test
       public void testPersonByid(){

          //    Person personid = personDao.getPersonid(1L);
              Person personid = personDao.findByPersonId(1L);

              logger.debug("返回的对象{}",personid.toString());
          }

          @Test
       public void testPersonByname(){

              Person per = personDao.findByName("员在");

              logger.debug("通过用户我查找返回的对象{}",per);
          }

          @Test
          @Transactional
          public void testsave(){

              Person person = new Person();
              person.setAddress("广州");
              person.setName("雅信sf");
              person.setJob("通信");
              person.setAge(10);
             Person save = personDao.save(person);

             logger.debug("保存对象成功：{}",save.toString());
          }

          @Test
       public void testNamedQuery(){

              List<Person> pers = personDao.pers();

              logger.debug("所有元素{}",pers.toString());


          }

          @Test
          public void modifyPerson(){

              //personDao.updatePersonINfo("wfg",1L);
              Person personid = personDao.getPersonid(1L);

              personid.setJob("快速");
              personDao.save(personid);
          }


          @Test
          public void testPager(){


              Pageable pageable = new PageRequest(1,2,Sort.Direction.DESC,"age");
              Page<Person> all = personDao.findAll(pageable);

              logger.debug("分页情况：{}",all.getContent().toString());
          }

          @Test
          public void testSort(){

              //适合单一属性排序
             // Sort sort  = new Sort(Sort.Direction.DESC,"age");

             // 通过Sort.Order对象创建Sort对象，适合对单一属性做排序
          //  Sort sort =  new Sort(new Sort.Order(Sort.Direction.DESC,"age"));

              //通过属性的List集合创建Sort对象，适合对多个属性，采取同一种排序方式的排序
            /*  List<String> sortproperties = new ArrayList<>();
              sortproperties.add("age");
              sortproperties.add("personId");*/
              //Sort sort = new Sort(Sort.Direction.DESC,sortproperties);

           //   通过Sort.Order对象的List集合创建Sort对象，适合所有情况，比较容易设置排序方式
              List<Sort.Order> sortproperties = new ArrayList<>();
              sortproperties.add(new Sort.Order(Sort.Direction.DESC,"age"));
              sortproperties.add(new Sort.Order(Sort.Direction.DESC,"personId"));

              Sort sort = new Sort(sortproperties);
              personDao.findAll(sort).forEach(System.out::println);
          }

          @Test
       public void testCache(){

              personDao.getPersonid(1L);
              personDao.getPersonid(1L);
          }

          @Test
        public void testpe(){

              Collection<Pe> getpe = personDao.getpe();

              getpe.forEach((x) ->System.out.println(x.getFullName()));
          }

          @Test
        public void testoptional(){

         /*     Optional<Person> getpersonoptionl = personDao.getpersonoptionl(1L);

              logger.debug("optional---{}",getpersonoptionl.get());*/

              Person person = new Person();
              person.setJob("sdf");
              person.setAge(32);
              person.setName("shdfk");
              person.setAddress("sdfjasdfjksal");
          }

          @Test
        public void testSpec(){

              Specification specification = SpecificationFactory.containsLike("name", "雅");

              PageRequest age = new PageRequest(0,2,new Sort(Sort.Direction.DESC, "age"));

              Page pager = personDao.findAll(specification, age);


                pager.getContent().forEach(System.out::println);

          }
}
