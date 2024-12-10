package com.totemdb.pgm.repository;

import com.totemdb.pgm.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.sql.Timestamp;

@Mapper
public interface AccountMapper {

    @Insert("Insert into usertest(username,password,regtime,type) values(#{username},#{password},#{reg_time},2)")
    void register(String username, String password, Timestamp reg_time);

    @Select("select username,password,id,type from usertest where username = #{username}")
    User getByUsername(String username);
}
