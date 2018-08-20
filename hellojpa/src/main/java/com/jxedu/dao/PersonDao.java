package com.jxedu.dao;

import com.jxedu.entity.Pe;
import com.jxedu.entity.Person;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.hibernate.jpa.QueryHints.HINT_CACHEABLE;

@Repository
public interface PersonDao extends JpaRepository<Person,Long>,JpaSpecificationExecutor {


     @Query("select  p  from  Person p")
     List<Person>  getPersons();

    // @Query("from  Person p where p.personId=:personId")
    @Query(value = "SELECT  * FROM t_person  P WHERE  P.personId=:personid",nativeQuery = true)
     //@QueryHints(value = { @QueryHint(name = HINT_COMMENT, value = "a query for pageable")})
     @QueryHints(value = { @QueryHint(name = HINT_CACHEABLE,value = "true")})
     Person getPersonid(@Param("personid") Long personId);

     List<Person> pers();

     Person  findByPersonId(Long personId);

     Person findByName(String name);

     @Modifying//更新查询   使用modifying注解是一定要Transactional注解 不然会报错 TransactionRequiredException
     @Transactional//开启事务
     @Query("update  Person  set address=:address where personId=:personId")
     void updatePersonINfo(@Param("address")String address, @Param("personId") Long personId);


   @Query("select  p.name as name,p.address as address from Person  p")
     Collection<Pe> getpe();

     @Query("select  p from Person p where p.personId=:personid")
     Optional<Person> getpersonoptionl(@Param("personid") Long personid);
}
