package com.jxedu.controller;

import com.jxedu.commons.Result;
import com.jxedu.entity.User;
import com.jxedu.task.TaskCompoent;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
     private TaskCompoent taskCompoent;

   private static  Logger logger = LoggerFactory.getLogger(HelloController.class);


    @ApiOperation(value = "hello测试", notes = "hello测试")
    @GetMapping(value = "/hello/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> hello(@PathVariable("name") String name, @RequestParam(value = "id", required = true, defaultValue = "1") Long id) {

        return ResponseEntity.ok(name + id);
    }

    @ApiOperation(value = "用户",notes = "user测试")
    @PostMapping(value = "/user",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> user(@RequestBody User user)
    {

         return ResponseEntity.ok(user);
    }

    @ApiOperation(value = "异步执行",notes = "Async")
    @GetMapping("task")
    public ResponseEntity<Result> aysnc(){

         taskCompoent.asyncTask();

         logger.debug("不等异步执行完");

         return ResponseEntity.ok(new Result("200","执行成功"));
    }
}
