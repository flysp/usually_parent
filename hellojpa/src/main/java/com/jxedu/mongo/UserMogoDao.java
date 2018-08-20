package com.jxedu.mongo;

import com.jxedu.entity.Person;
import com.jxedu.entity.UserMong;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMogoDao  extends MongoRepository<UserMong,String> {
}
