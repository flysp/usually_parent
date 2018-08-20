package com.jxedu.controller;

import com.jxedu.entity.TestVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TestVoController {



          @GetMapping("/test01")
          public String thymeleaf(ModelMap map){

              List<TestVo> testVos = new ArrayList<>();

              testVos.add(new TestVo("数学",10,new Date(),1));
              testVos.add(new TestVo("数学0001",70,new Date(),2));
              testVos.add(new TestVo("数学01",100,new Date(),3));

              map.put("test",testVos);
              map.put("html","<h1>sdfasd</h1>");

              List<String> list=new ArrayList<String>();
              list.add("1s");
              list.add("2s");
              list.add("3s");
              map.put("list",list);

              return "test";
          }

}
