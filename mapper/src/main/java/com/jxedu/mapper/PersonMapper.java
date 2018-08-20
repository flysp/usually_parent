package com.jxedu.mapper;

import com.jxedu.MyMapper;
import com.jxedu.bean.Person;
import org.apache.ibatis.annotations.CacheNamespace;

//@CacheNamespace
public interface PersonMapper extends MyMapper<Person> {
}
