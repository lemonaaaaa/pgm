package com.totemdb.pgm.repository;

import com.github.pagehelper.Page;
import com.totemdb.pgm.entity.Article;
import com.totemdb.pgm.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("select * from paper")
    Page<Article> getAllArticles();

    @Select("select * from paper where id = #{id}")
    Article getArticleByID(Integer id);

    @Insert("insert into paper(id,title,author,uploader,uploadtime,count,show) " +
            "values(#{id},#{title},#{author},#{userID},#{uploadtime},0,#{show})")
    void uploadArticle(Article article,Integer userID);

    @Delete("delete from paper where id = #{id}")
    void deleteArticle(Integer id);

    @Select("select * from paper where author like CONCAT('%', #{author}, '%')")
    List<Article> filterArticleByAuthor(String author);

    @Update("update paper set count = count + 1 where id = #{id}")
    void downloadArticle(Integer id);
}
