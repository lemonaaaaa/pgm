package com.totemdb.pgm.service;

import com.totemdb.pgm.entity.PageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.totemdb.pgm.entity.Book;
import com.totemdb.pgm.entity.Record;
import com.totemdb.pgm.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public PageBean getAllBooks(Integer page, Integer pageSize){
        //1、设置分页参数
        PageHelper.startPage(page, pageSize);

        //2、执行查询
        Page<Book> bookList = bookMapper.getAllBooks();

        //3、封装PageBean
        PageBean pageBean = new PageBean(bookList.getTotal(),bookList.getResult());
        return pageBean;
    }

    @Override
    public Book getBookByID(Integer id){
        Book book = bookMapper.getBookByID(id);
        return book;
    }

    @Override
    public void addBook(Book book){
        bookMapper.addBook(book);
    }

    @Override
    public void deleteBook(Integer id){
        bookMapper.deleteBook(id);
    }

    @Override
    public boolean borrowBook(Integer bookID, Integer userId){
        Book book = bookMapper.getBookByID(bookID);
        LocalDate currentTime = LocalDate.now();

        if(book.getAvailable() == 0){
            return false;
        }else{
            bookMapper.availableDecrease(bookID);
            bookMapper.countIncrease(bookID);
            bookMapper.borrowRecord(bookID,userId,currentTime);
            return true;
        }
    }

    @Override
    public boolean returnBook(Integer bookID, Integer userId){
        Book book = bookMapper.getBookByID(bookID);
        LocalDate currentTime = LocalDate.now();

        if(book == null){
            return false;
        }else{
            bookMapper.availableIncrease(bookID);
            bookMapper.returnRecord(bookID,userId,currentTime);
            return true;
        }
    }

    @Override
    public List<Book> filterBook(Book book){
        List<Book> list = bookMapper.filterBook(book);
        return list;
    }

    @Override
    public boolean borrowedBook(Integer bookId, Integer userId) {
        Record record = bookMapper.getBookStatus(bookId, userId);
        if(record == null) { return false;}
        else if(record.getStatus()==1) {return true;}
        else if(record.getStatus()==0) {return false;}
        return false;
    }
}
