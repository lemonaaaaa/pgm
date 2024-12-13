package com.totemdb.pgm.repository;

import com.totemdb.pgm.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("insert into comment(userid,targetid,targettype,comment) values (#{userID},#{targetID},#{type},#{comment})")
    void addComment(int userID,int targetID,String type,String comment);

    @Select("select * from comment where targetid = #{id} and targettype = #{type}")
    List<Comment> getCommentList(int id, String type);
}

