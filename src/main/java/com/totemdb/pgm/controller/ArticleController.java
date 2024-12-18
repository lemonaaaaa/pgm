package com.totemdb.pgm.controller;

import com.totemdb.pgm.entity.*;
import com.totemdb.pgm.entity.dto.UserDto;
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
    private ResponseMessage<Article> uploadArticle(@RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam String url) {
        Article article = articleService.selectArticleExactly(title, author);

        if (article == null) {
            Map<String,Object> map = ThreadLocalUtil.get();
            Integer userID = (Integer)map.get("id");
            Article articleNew = new Article();
            articleNew.setTitle(title);
            articleNew.setAuthor(author);
            articleNew.setUploader(userID);
            articleNew.setPublisher(publisher);
            articleNew.setUrl(url);

            articleService.uploadArticle(articleNew);
            return ResponseMessage.success();
        }else {
            return ResponseMessage.error("论文已存在");
        }

    }

    @PutMapping
    private ResponseMessage<Article> updateUser(@RequestParam Integer id, @RequestParam String title, @RequestParam String author) {
        articleService.updateArticle(title, author, id.longValue());
        return ResponseMessage.success();
    }

    @DeleteMapping("/delete")
    private ResponseMessage<Article> deleteArticle(@RequestBody Article article) {

        articleService.deleteArticle(article.getId());
        return ResponseMessage.success();
    }

    @PostMapping("/filter1")
    private ResponseMessage<List<Article>> filterArticleByTitle(@RequestParam String title){
        List<Article> list = articleService.filterArticleByTitle(title);
        return ResponseMessage.success(list);
    }
    @PostMapping("/filter2")
    private ResponseMessage<List<Article>> filterArticleByAuthor(@RequestParam String author){
        List<Article> list = articleService.filterArticleByAuthor(author);
        return ResponseMessage.success(list);
    }

    @PostMapping("/filter3")
    private ResponseMessage<List<Article>> filterArticleByPublisher(@RequestParam String publisher){
        List<Article> list = articleService.filterArticleByPublisher(publisher);
        return ResponseMessage.success(list);
    }

    @PostMapping("/download")
    private ResponseMessage<Article> downloadArticle(@RequestParam Integer id) {
        Article article = articleService.getArticleByID(id);
        return ResponseMessage.success(article);
    }
}
