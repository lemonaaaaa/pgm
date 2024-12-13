package com.totemdb.pgm.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.totemdb.pgm.entity.Article;
import com.totemdb.pgm.entity.Book;
import com.totemdb.pgm.entity.PageBean;
import com.totemdb.pgm.repository.ArticleMapper;
import com.totemdb.pgm.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ArticleService implements IArticleService{
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> getAllArticles(){
        List<Article> articleList = articleMapper.getAllArticles();
        return articleList;
    }

    @Override
    public Article getArticleByID(Integer id){
        Article article = articleMapper.getArticleByID(id);
        return article;
    }

    @Override
    public void uploadArticle(Article article){
        Timestamp uploadtime = new Timestamp(System.currentTimeMillis());
        article.setUploadtime(uploadtime);
        articleMapper.uploadArticle(article);
    }

    @Override
    public void updateArticle(String title, String author, Long id){
        articleMapper.updateArticle(title, author, id);
    }

    @Override
    public void deleteArticle(Long id){
        articleMapper.deleteArticle(id);
    }

    @Override
    public List<Article> filterArticleByAuthor(String author){
        List<Article> list = articleMapper.filterArticleByAuthor(author);
        return list;
    }

    @Override
    public void downloadArticle(Integer id){
        articleMapper.downloadArticle(id);
    }

    @Override
    public Article selectArticleExactly(String title, String author){
        return articleMapper.selectArticleExactly(title,author);
    }

    @Override
    public List<Article> filterArticleByTitle(String title) {
        List<Article> list = articleMapper.filterArticleByTitle(title);
        return list;
    }

    @Override
    public List<Article> filterArticleByPublisher(String publisher) {
        List<Article> list = articleMapper.filterArticleByPublisher(publisher);
        return list;
    }
}
