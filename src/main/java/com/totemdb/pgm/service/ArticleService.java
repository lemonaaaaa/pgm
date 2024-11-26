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

import java.util.List;

@Service
public class ArticleService implements IArticleService{
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public PageBean getAllArticles(Integer page, Integer pageSize){
        //1、设置分页参数
        PageHelper.startPage(page, pageSize);

        //2、执行查询
        Page<Article> articleList = articleMapper.getAllArticles();

        //3、封装PageBean
        PageBean pageBean = new PageBean(articleList.getTotal(),articleList.getResult());
        return pageBean;
    }

    @Override
    public Article getArticleByID(Integer id){
        Article article = articleMapper.getArticleByID(id);
        return article;
    }

    @Override
    public void uploadArticle(Article article,Integer userID){
        articleMapper.uploadArticle(article,userID);
    }

    @Override
    public void deleteArticle(Integer id){
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
}
