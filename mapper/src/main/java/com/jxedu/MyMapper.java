package com.jxedu;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@RegisterMapper
public interface  MyMapper<T> extends Mapper<T> {

    @UpdateProvider( type = BatchProvider.class,method = "dynamicSQL")
    void updateBatch(List<T> list);

      @InsertProvider(type = BatchProvider.class,method = "dynamicSQL")
     void insertBatch(List<T> list);
}
