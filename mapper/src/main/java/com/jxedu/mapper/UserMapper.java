package com.jxedu.mapper;

import com.jxedu.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface UserMapper extends /*BaseMapper<User> */ Mapper<User> {

     @Select("SELECT * FROM t_user WHERE id=#{userId}")
      User getUserById(@Param("userId") Long userId);

     User getUserById2(@Param("userId") Long userId);

     void batch(List<User> users);
}
