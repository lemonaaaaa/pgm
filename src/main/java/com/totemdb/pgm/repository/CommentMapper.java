package com.totemdb.pgm.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    @Insert("insert into comment(userid,targetid,targettype,comment) values (#{userID},#{targetID},#{type},#{comment})")
    void addComment(int userID,int targetID,String type,String comment);
}
