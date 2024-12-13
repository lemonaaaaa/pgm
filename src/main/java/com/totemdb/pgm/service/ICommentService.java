package com.totemdb.pgm.service;

import com.totemdb.pgm.entity.Comment;

import java.util.List;

public interface ICommentService {
    void addComment(int userID,int targetID,String type,String comment);

    List<Comment> getCommentList(int id,String type);
}
