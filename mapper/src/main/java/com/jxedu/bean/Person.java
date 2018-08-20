package com.jxedu.bean;

import com.jxedu.handler.AddressTypeHandler;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 默认是驼峰命名方式
 */
@Table(name = "t_person")
//@NameStyle(Style.camelhumpAndUppercase)
public class Person implements Serializable {



     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "personId")
     private Long personId;

     /*private String userAddress;*/

    @ColumnType(column = "USER_ADDRESS",typeHandler = AddressTypeHandler.class)
    private Address address;

 /*    private String userJob;*/

    @Column(name = "USER_JOB")
     private Season season;

     private String userName;

     private  Integer personAge;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    /*public String getUserAddress() {

        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }*/

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

/*
    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }
*/

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPersonAge() {
        return personAge;
    }

    public void setPersonAge(Integer personAge) {
        this.personAge = personAge;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", userAddress='" + address + '\'' +
                ", userJob='" + season + '\'' +
                ", userName='" + userName + '\'' +
                ", personAge=" + personAge +
                '}';
    }
}
