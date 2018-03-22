
package com.api.publish_article.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.publish_article.domain.Article;
import com.api.publish_article.event.ArticleEvent;
import com.api.publish_article.repo.ArticleRepository;

/**
 * @author rkarim
 *
 */
@Service
public class ArticleServiceHandler implements ArticleService{
  
  @Autowired
  private ArticleRepository articleRepo;

  /* (non-Javadoc)
   * @see com.api.publish_article.service.ArticleService#create(com.api.publish_article.event.ArticleEvent)
   */
  @Override
  public Integer create(ArticleEvent data) {
    
    Article article =new Article(data.getHeader(), data.getDescription(), data.getText(),
                                data.getPublishDate(),data.getAuthor(), data.getKeywords());
    
    articleRepo.save(article);
    
    return article.getId();
  }

  /* (non-Javadoc)
   * @see com.api.publish_article.service.ArticleService#update(java.lang.Integer, com.api.publish_article.event.ArticleEvent)
   */
  @Override
  public Integer update(Integer id, ArticleEvent data) {
    Article article =new Article(data.getHeader(), data.getDescription(), data.getText(),
        data.getPublishDate(),data.getAuthor(), data.getKeywords());
    article.setId(id);
    articleRepo.save(article);
    
    return article.getId();
  }

  /* (non-Javadoc)
   * @see com.api.publish_article.service.ArticleService#delete(java.lang.Integer)
   */
  @Override
  public Integer delete(Integer id) {
    articleRepo.deleteById(id);
    
    return 0;
  }

  /* (non-Javadoc)
   * @see com.api.publish_article.service.ArticleService#findByAuthor(java.lang.String)
   */
  @Override
  public List<Article> findByAuthor(String name) {
    List<Article> articles = articleRepo.findByAuthor(name);
    return articles;
  }

  /* (non-Javadoc)
   * @see com.api.publish_article.service.ArticleService#findOne(java.lang.Integer)
   */
  @Override
  public Article findOne(Integer id) {
    return articleRepo.getOne(id);
  }

  /* (non-Javadoc)
   * @see com.api.publish_article.service.ArticleService#findBetweenDates(java.time.LocalDateTime, java.time.LocalDateTime)
   */
  @Override
  public List<Article> findBetweenDates(String start, String end) {
    LocalDateTime startDate = formatDate(start);
    LocalDateTime endDate = formatDate(start);
    List<Article> articles = articleRepo.findByPublishDateBetween(startDate, endDate);
    return articles;
  }

  /**
   * 
   */
  private LocalDateTime formatDate(String dateStr) {
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(dateStr, formatter);
    return dateTime;
  }

  /* (non-Javadoc)
   * @see com.api.publish_article.service.ArticleService#findByKeyWords(java.lang.String)
   */
  @Override
  public List<Article> findByKeyWords(String keywords) {
    List<Article> articles = articleRepo.findByKeywordsIn(keywords);
    return articles;
  }

}
