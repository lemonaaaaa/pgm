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
    public ResponseMessage<List<Article>> getAllArticles()  {
        List<Article> list = articleService.getAllArticles();
        return ResponseMessage.success(list);
    }

    @PostMapping
    private ResponseMessage<Article> getArticleByID(@RequestParam Integer id) {
        Article article = articleService.getArticleByID(id);
        return ResponseMessage.success(article);
    }

    @PostMapping("/upload")
    private ResponseMessage<Article> uploadArticle(@RequestParam String title, @RequestParam String author) {
        Article article = articleService.selectArticleExactly(title, author);

        if (article == null) {
            Map<String,Object> map = ThreadLocalUtil.get();
            Integer userID = (Integer)map.get("id");
            Article articleNew = new Article();
            article.setTitle(title);
            article.setAuthor(author);
            article.setUploader(userID);

            articleService.uploadArticle(articleNew);
            return ResponseMessage.success();
        }else {
            return ResponseMessage.error("论文已存在");
        }

    }

    @DeleteMapping("/delete")
    private ResponseMessage<Article> deleteArticle(@RequestBody Article article) {

        articleService.deleteArticle(article.getId());
        return ResponseMessage.success();
    }

    @PostMapping("/filter")
    private ResponseMessage<List<Article>> filterArticleByAuthor(@RequestParam String author){
        List<Article> list = articleService.filterArticleByAuthor(author);
        return ResponseMessage.success(list);
    }

    @PostMapping("/download")
    private ResponseMessage<Article> downloadArticle(@RequestParam Integer id) {
        Article article = articleService.getArticleByID(id);
        articleService.downloadArticle(id);
        return ResponseMessage.success(article);
    }
}
