package com.totemdb.pgm.service;

import com.totemdb.pgm.entity.PageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.totemdb.pgm.entity.Book;
import com.totemdb.pgm.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean borrowBook(Integer id){
        Book book = bookMapper.getBookByID(id);
        if(book.getAvailable() == 0){
            return false;
        }else{
            bookMapper.availableDecrease(id);
            bookMapper.countIncrease(id);
            return true;
        }
    }

    @Override
    public boolean returnBook(Integer id){
        Book book = bookMapper.getBookByID(id);
        if(book == null){
            return false;
        }else{
            bookMapper.availableIncrease(id);
            bookMapper.countDecrease(id);
            return true;
        }
    }

    @Override
    public List<Book> filterBook(Book book){
        List<Book> list = bookMapper.filterBook(book);
        return list;
    }
}
