package com.jxedu.dao;

import com.jxedu.entity.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyOrderRepository extends JpaSpecificationExecutor<MyOrder>,JpaRepository<MyOrder,Long> {
}
