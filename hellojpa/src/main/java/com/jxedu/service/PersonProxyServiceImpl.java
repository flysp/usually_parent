package com.jxedu.service;

public class PersonProxyServiceImpl implements  PersonProxyService {

      private  static  int count =0;
    @Override
    public void info() {
        count++;
        System.out.println("乾可。。。。。。");

        System.out.println(count);
    }

    @Override
    public void info2() {

        System.out.println("当局者迷。。。。。");

         throw new RuntimeException("抛出的。。。。");
    }
}
