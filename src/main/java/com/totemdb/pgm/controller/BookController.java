package com.totemdb.pgm.controller;


import com.totemdb.pgm.entity.PageBean;
import com.totemdb.pgm.entity.ResponseMessage;
import com.totemdb.pgm.entity.User;
import com.totemdb.pgm.entity.Book;
import com.totemdb.pgm.service.BookService;
import com.totemdb.pgm.utils.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/book")    //localhost:8080/book
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseMessage<PageBean> getAllBooks(@RequestParam(defaultValue = "1")Integer page,
                                             @RequestParam(defaultValue = "10") Integer pageSize)  {
        PageBean pagebean = bookService.getAllBooks(page,pageSize);
        return ResponseMessage.success(pagebean);
    }

    @PostMapping
    private ResponseMessage<Book> getBookByID(@RequestParam Integer id) {
        Book book = bookService.getBookByID(id);
        return ResponseMessage.success(book);
    }

    @PostMapping("/add")
    private ResponseMessage<Book> addBook(@Validated @RequestBody Book book) {
        bookService.addBook(book);
        return ResponseMessage.success();
    }

    @DeleteMapping("/delete")
    private ResponseMessage<Book> deleteBook(@RequestParam Integer id) {
        bookService.deleteBook(id);
        return ResponseMessage.success();
    }

    @PostMapping("/borrow")
    private ResponseMessage<Book> borrowBook(@RequestParam Integer bookID) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userID = (Integer)map.get("id");

        boolean flag = bookService.borrowBook(bookID,userID);
        return flag?ResponseMessage.success():ResponseMessage.error("图书已经借完");
    }

    @PostMapping("/return")
    private ResponseMessage<Book> returnBook(@RequestParam Integer bookId) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userID = (Integer)map.get("id");

        boolean flag = bookService.returnBook(bookId,userID);
        return flag?ResponseMessage.success():ResponseMessage.error("图书不存在");
    }

    @PostMapping("/filter")
    private ResponseMessage<List<Book>> filterBook(@Validated @RequestBody Book book){
        List<Book> list = bookService.filterBook(book);
        return ResponseMessage.success(list);
    }
}