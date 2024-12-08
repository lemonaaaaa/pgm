package com.totemdb.pgm.controller;

import com.totemdb.pgm.entity.Book;
import com.totemdb.pgm.entity.Comment;
import com.totemdb.pgm.entity.ResponseMessage;
import com.totemdb.pgm.service.BookService;
import com.totemdb.pgm.service.CommentService;
import com.totemdb.pgm.utils.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    private ResponseMessage<Comment> addComment(@RequestParam Integer id,@RequestParam String type,@RequestParam String comment) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userID = (Integer)map.get("id");

        commentService.addComment(userID,id,type,comment);
        return ResponseMessage.success();
    }
}
