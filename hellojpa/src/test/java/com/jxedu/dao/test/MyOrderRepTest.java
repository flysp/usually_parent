package com.jxedu.dao.test;

import com.jxedu.dao.CustomerRepository;
import com.jxedu.entity.Customer;
import com.jxedu.entity.MyOrder;
import com.jxedu.dao.MyOrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.*;

@RunWith(SpringRunner.class)
@ContextHierarchy(value = {
        @ContextConfiguration(locations = {"classpath:applicationContext-jpa.xml"})
})
public class MyOrderRepTest {

    @Autowired
    private MyOrderRepository myOrderRepository;


     @Test
     public void tt(){

         myOrderRepository.findAll().forEach(System.out::println);
     }
    @Test
    public void test01(){

        Specification<MyOrder> specification;
        specification = new Specification<MyOrder>() {
            @Override
            public Predicate toPredicate(Root<MyOrder> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                //  //声明并创建MyOrder的CriteriaQuery对象
                CriteriaQuery<MyOrder> query = criteriaBuilder.createQuery(MyOrder.class);

                //连接的时候，要以声明的根查询对象（这里是root，也可以自己创建）进行join
                //                    //Join&lt;Z,X&gt;是Join生成的对象，这里的Z是被连接的对象，X是目标对象，
                //                    //  连接的属性字段是被连接的对象在目标对象的属性，这里是我们在MyOrder内声明的customer
                //                    //join的第二个参数是可选的，默认是JoinType.INNER(内连接 inner join)，也可以是JoinType.LEFT（左外连接 left join）

                Join<Customer,MyOrder> join = root.join("customer1", JoinType.INNER);
                //用CriteriaQuery对象拼接查询条件，这里只增加了一个查询条件，cId=1

                query.select(join).where(criteriaBuilder.equal(root.get("cId"),1));
                //通过getRestriction获得Predicate对象
                Predicate restriction = query.getRestriction();

                return restriction;
            }

        };

        resultPrint(specification);
    }

    private void resultPrint(Specification<MyOrder> spec) {
        //分页查询
        Pageable pageable = new PageRequest(0,10, Sort.Direction.DESC,"id");
        //查询的分页结果
        Page<MyOrder> page =myOrderRepository.findAll(spec,pageable);

        System.out.println(page);
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        for (MyOrder c:page.getContent()){
            System.out.println(c.toString());
        }
    }

}
