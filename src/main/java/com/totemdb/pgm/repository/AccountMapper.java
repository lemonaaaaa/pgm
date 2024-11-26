package com.totemdb.pgm.repository;

import com.totemdb.pgm.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {

    @Insert("Insert into wallet(username,password) values(#{username},#{password})")
    void register(String username, String password);

    @Select("select username,password from wallet where username = #{username}")
    User getByUsername(String username);
}
