package com.jxedu;

import com.jxedu.task.TaskCompoent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy(value =  {
        @ContextConfiguration(locations = {"classpath:applicationContext-IOC.xml"})

})
@EnableAsync
public class TaskTest {


    @Autowired
     private TaskCompoent taskCompoent;

  private static   Logger logger = LoggerFactory.getLogger(TaskTest.class);
       @Test
      public void  testTask(){

           String result = taskCompoent.commonsTask();

          logger.debug("result值:{}",result);
       }

       @Test
    public  void testTask2() throws InterruptedException {

         taskCompoent.asyncTask();

         logger.debug("异步了。。。。。");

           Thread.sleep(20000);
       }

}
