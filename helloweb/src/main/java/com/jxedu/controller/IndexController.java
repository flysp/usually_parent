package com.jxedu.controller;

import com.jxedu.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {


       @PostMapping("/login")
     public String  login(User user){


             return "index";
       }
}
