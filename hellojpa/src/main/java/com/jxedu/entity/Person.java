package com.jxedu.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

/**
 * PERSON 实体类
 */
@Entity
@Table(name = "t_person")
@NamedQuery(name = "Person.pers" ,query = "select  p from Person p")
@Cacheable
@Document
/*@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY,region = "mycache")*/
public class Person {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long personId;

      @Column(name = "USER_NAME")
       private String name;

      @Column(name = "USER_ADDRESS")
       private String address;

      @Column(name = "USER_JOB")
       private String job;

      @Column(name = "PERSON_AGE")
      private Integer age;


    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", job='" + job + '\'' +
                ", age=" + age +
                '}';
    }
}
