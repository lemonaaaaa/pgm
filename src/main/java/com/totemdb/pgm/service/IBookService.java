package com.totemdb.pgm.service;

import com.totemdb.pgm.entity.PageBean;

import com.totemdb.pgm.entity.Book;

import java.util.List;

public interface IBookService {

    PageBean getAllBooks(Integer page, Integer pageSize);
    /*
    * 查询所有用户信息
    * 分页查询
    */
    Book getBookByID(Integer id);
    /*
    * 根据id查询图书
    * @RequestParam id
    */
    void addBook(Book book);
    /*
    * 管理员新增图书
    * @RequestBody book
    */
    void deleteBook(Integer id);
    /*
     * 管理员根据id删除图书
     * @RequestParam id
     */
    boolean borrowBook(Integer bookID, Integer userId);
    /*
    * 借书
    * @RequestParam id
    */
    boolean returnBook(Integer bookID, Integer userId);
    /*
     * 还书
     * @RequestParam id
     */
    List<Book> filterBook(Book book);

    boolean borrowedBook(Integer bookId, Integer userId);

    Integer bookTotal();

    PageBean getAllRecords(Integer page, Integer pageSize);

    Integer recordTotal();
}
