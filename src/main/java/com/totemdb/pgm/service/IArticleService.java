package com.totemdb.pgm.service;

import com.totemdb.pgm.entity.Article;
import com.totemdb.pgm.entity.Book;
import com.totemdb.pgm.entity.PageBean;
import com.totemdb.pgm.entity.User;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface IArticleService {
    List<Article> getAllArticles();

    Article getArticleByID(Integer id);

    void uploadArticle(Article article);

    void deleteArticle(Long id);

    List<Article> filterArticleByAuthor(String author);

    void downloadArticle(Integer id);

    Article selectArticleExactly(String title, String author);

    void updateArticle(String title, String author, Long id);

    List<Article> filterArticleByTitle(String title);

    List<Article> filterArticleByPublisher(String publisher);
}
