package com.jxedu.bean;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.*;

@Table(name = "t_user")
public class User {

      @Id
      //@GeneratedValue(strategy = GenerationType.IDENTITY)
      //@GeneratedValue(generator = "JDBC")
  //  @KeySql(useGeneratedKeys = true,dialect = IdentityDialect.MYSQL)
      @KeySql(useGeneratedKeys = true)
      private Long id;

      private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
