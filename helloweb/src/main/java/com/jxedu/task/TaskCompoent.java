package com.jxedu.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TaskCompoent {



     public String  commonsTask(){

           asyncTask();
         System.out.println("正常执行了！！！");
           return  "Hello World";
     }

     @Async
      public  void asyncTask(){

          try {
              Thread.sleep(10000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println("异步执行了。。。。。。");
      }
}
