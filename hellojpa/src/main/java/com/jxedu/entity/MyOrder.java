package com.jxedu.entity;

import com.jxedu.entity.Customer;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_order")
public class MyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       private String code;

       private Long cId;

       private BigDecimal total;

      @OneToOne
      @JoinColumn(name = "cId", insertable = false, updatable = false)
       private Customer customer1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer1;
    }

    public void setCustomer(Customer customer) {
        this.customer1 = customer;
    }

    @Override
    public String toString() {
        return "MyOrder{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", cId=" + cId +
                ", total=" + total +
                ", customer=" + customer1+
                '}';
    }
}
