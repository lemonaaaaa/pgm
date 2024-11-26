package com.totemdb.pgm.controller;

import com.totemdb.pgm.entity.Article;
import com.totemdb.pgm.entity.Book;
import com.totemdb.pgm.entity.PageBean;
import com.totemdb.pgm.entity.ResponseMessage;
import com.totemdb.pgm.service.ArticleService;
import com.totemdb.pgm.service.BookService;
import com.totemdb.pgm.utils.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public ResponseMessage<PageBean> getAllArticles(@RequestParam(defaultValue = "1")Integer page,
                                                 @RequestParam(defaultValue = "10") Integer pageSize)  {
        PageBean pagebean = articleService.getAllArticles(page,pageSize);
        return ResponseMessage.success(pagebean);
    }

    @PostMapping
    private ResponseMessage<Article> getArticleByID(@RequestParam Integer id) {
        Article article = articleService.getArticleByID(id);
        return ResponseMessage.success(article);
    }

    @PostMapping("/add")
    private ResponseMessage<Article> uploadArticle(@Validated @RequestBody Article article) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userID = (Integer)map.get("id");

        articleService.uploadArticle(article,userID);
        return ResponseMessage.success();
    }

    @DeleteMapping("/delete")
    private ResponseMessage<Article> deleteArticle(@RequestParam Integer id) {
        articleService.deleteArticle(id);
        return ResponseMessage.success();
    }

    @PostMapping("/filter")
    private ResponseMessage<List<Article>> filterArticleByAuthor(@RequestParam String author){
        List<Article> list = articleService.filterArticleByAuthor(author);
        return ResponseMessage.success(list);
    }

    @GetMapping("/download")
    private ResponseMessage<Article> downloadArticle(@RequestParam Integer id) {
        Article article = articleService.getArticleByID(id);
        articleService.downloadArticle(id);
        return ResponseMessage.success(article);
    }
}
