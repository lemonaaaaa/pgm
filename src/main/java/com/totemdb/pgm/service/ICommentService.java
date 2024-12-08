package com.totemdb.pgm.service;

public interface ICommentService {
    void addComment(int userID,int targetID,String type,String comment);
}
