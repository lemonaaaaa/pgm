package com.totemdb.pgm.service;

import com.totemdb.pgm.entity.Article;
import com.totemdb.pgm.entity.Book;
import com.totemdb.pgm.entity.PageBean;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface IArticleService {
    PageBean getAllArticles(Integer page, Integer pageSize);
    /*
     * 查询所有用户信息
     * 分页查询
     */
    Article getArticleByID(Integer id);
    /*
     * 根据id查询图书
     * @RequestParam id
     */
    void uploadArticle(Article article,Integer userID);
    /*
     * 管理员新增图书
     * @RequestBody book
     */
    void deleteArticle(Integer id);
    /*
     * 管理员根据id删除图书
     * @RequestParam id
     */
    List<Article> filterArticleByAuthor(String author);

    void downloadArticle(Integer id);
}
