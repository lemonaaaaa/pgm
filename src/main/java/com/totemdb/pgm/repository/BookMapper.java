package com.totemdb.pgm.repository;

import com.github.pagehelper.Page;
import com.totemdb.pgm.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("select * from book")
    Page<Book> getAllBooks();

    @Select("select * from book where id = #{id}")
    Book getBookByID(Integer id);

    @Insert("insert into book(id,title,author,publishtime,total,available,count,show,index) " +
            "values(#{id},#{title},#{author},#{publishtime},#{total},#{available},#{count},#{show},#{index})")
    void addBook(Book book);

    @Delete("delete from book where id = #{id}")
    void deleteBook(Integer id);

    @Update("update book set available = available - 1 where id = #{id}")
    void availableDecrease(Integer id);

    @Update("update book set available = available + 1 where id = #{id}")
    void availableIncrease(Integer id);

    @Update("update book set count = count + 1 where id = #{id}")
    void countIncrease(Integer id);

    @Update("update book set count = count - 1 where id = #{id}")
    void countDecrease(Integer id);

    List<Book> filterBook(Book book);
}
