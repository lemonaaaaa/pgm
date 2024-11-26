package com.totemdb.pgm.repository;

import com.totemdb.pgm.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {

    @Insert("Insert into user(username,password,id) values(#{username},#{password},#{id})")
    void register(String username, String password,String id);

    @Select("select username,password from user where username = #{username}")
    User getByUsername(String username);
}
