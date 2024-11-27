package com.totemdb.pgm.service;

import com.totemdb.pgm.entity.Article;
import com.totemdb.pgm.entity.Book;
import com.totemdb.pgm.entity.PageBean;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface IArticleService {
    PageBean getAllArticles(Integer page, Integer pageSize);

    Article getArticleByID(Integer id);

    void uploadArticle(Article article);

    void deleteArticle(Integer id);

    List<Article> filterArticleByAuthor(String author);

    void downloadArticle(Integer id);
}
