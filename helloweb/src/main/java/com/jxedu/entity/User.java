package com.jxedu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户")
public class User {

      @ApiModelProperty("用户名")
       private String name;

      @ApiModelProperty("用户地址 ")
       private String address;

      @ApiModelProperty("密码")
      private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
