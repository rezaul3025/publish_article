package com.api.publish_article.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.publish_article.domain.Article;
import com.api.publish_article.event.ArticleEvent;
import com.api.publish_article.service.ArticleService;

/**
 * @author rkarim
 *
 */
@RestController
@RequestMapping(value="/api/v1/article")
public class ArticleController {
  
  @Autowired
  private ArticleService articleService;
  
  @RequestMapping(value="/create", method=RequestMethod.POST)
  public Integer create(@RequestBody ArticleEvent data){
    return articleService.create(data);
  }
  
  @RequestMapping(value="/{id}/update", method=RequestMethod.POST)
  public Integer update(@PathVariable("id") Integer id,@RequestBody ArticleEvent data){
    return articleService.update(id, data);
  }
  
  @RequestMapping(value="/{id}/delete", method=RequestMethod.DELETE)
  public Integer delete(@PathVariable("id") Integer id){
    articleService.delete(id);
    return 0;
  }
  
  @RequestMapping(value="/author", method=RequestMethod.GET)
  public List<Article> findByAuthor(@RequestParam("name") String name){
    return articleService.findByAuthor(name);
  }
  
  @RequestMapping(value="/findone/{id}", method=RequestMethod.GET)
  public Article findOne(@PathVariable("id") Integer id){
    return articleService.findOne(id);
  }
  
  @RequestMapping(value="/findbetween", method=RequestMethod.GET)
  public List<Article> findBetweenDates(@RequestParam("start") String start, @RequestParam("end") String end){
    return articleService.findBetweenDates(start, end);
  }
  
  @RequestMapping(value="/findkeywords", method=RequestMethod.GET)
  public List<Article> findByKeyWords(@RequestParam("keywords") String keywords){
    return articleService.findByKeyWords(keywords);
  }

}
