package com.totemdb.pgm.repository;

import com.github.pagehelper.Page;
import com.totemdb.pgm.entity.Book;
import com.totemdb.pgm.entity.Record;
import org.apache.ibatis.annotations.*;
import org.springframework.data.relational.core.sql.In;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface BookMapper {

    @Select("select * from book")
    Page<Book> getAllBooks();

    @Select("select * from book where id = #{id}")
    Book getBookByID(Integer id);

    @Insert("insert into book(title,author,publishtime,total,available,count,show,index) " +
            "values(#{title},#{author},#{publishtime},#{total},#{available},0,#{show},#{index})")
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

    @Insert("insert into record(bookid,userid,karutime,status) values (#{bookID},#{userID},#{borrowDate},1)")
    void borrowRecord(Integer bookID, Integer userID, LocalDate borrowDate);

    @Update("update record set kaesutime = #{returnDate},status = 0 where bookid = #{bookID} and userid = #{userID}")
    void returnRecord(Integer bookID, Integer userID, LocalDate returnDate);

    List<Book> filterBook(Book book);

    @Select("select * from record where userid = #{userId} and bookid = #{bookId} order by id DESC limit 1")
    Record getBookStatus(Integer bookId, Integer userId);

    @Select("select count(*) from book")
    Integer getBookTotal();

    @Select("select * from record")
    Page<Record> getAllRecords();

    @Select("select count(*) from record")
    Integer getRecordTotal();

    @Select("select * from record where userid = #{userId}")
    Page<Record> getUserRecords(Integer userId);

    @Select("select count(*) from record where userid = #{userId}")
    Integer getRecordUserTotal(Integer userId);
}
