package com.jxedu.controller;


import com.jxedu.commons.Result;
import com.jxedu.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestTestController {


         @ApiOperation(value = "GEt")
          @GetMapping("user")
          public ResponseEntity<Result> userget(@RequestParam("id") Long id){

              User user = new User();
              user.setAddress("广州");
              user.setName("幸福");

               return ResponseEntity.ok(new Result("200",user));
          }

       @ApiOperation(value = "post")
          @PostMapping("user")
         public ResponseEntity<Result> userpost( @RequestBody  User user){

              return ResponseEntity.ok(new Result("200",user));
          }


          @ApiOperation(value = "put")
          @PutMapping(value = "user",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
         public ResponseEntity<Result> userput(@RequestBody User user){

              return ResponseEntity.ok(new Result("200",user));
          }


          @ApiOperation(value = "delete")
          @DeleteMapping("user/{json}")
          public ResponseEntity<Result> userdelete(@PathVariable String json,@RequestBody User user){

              return ResponseEntity.ok(new Result("200",json+user.toString()));
          }


             @PostMapping("userd")
              public ResponseEntity<Result> down(User user){



                return ResponseEntity.ok(new Result("200",user));
              }
}
