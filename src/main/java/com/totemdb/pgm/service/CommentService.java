package com.totemdb.pgm.service;

import com.totemdb.pgm.repository.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    public void addComment(int userID,int targetID,String type,String comment){
        commentMapper.addComment(userID,targetID,type,comment);
    }
}
