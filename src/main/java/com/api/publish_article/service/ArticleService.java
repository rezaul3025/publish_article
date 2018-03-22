
package com.api.publish_article.service;

import java.util.List;

import com.api.publish_article.domain.Article;
import com.api.publish_article.event.ArticleEvent;

/**
 * @author rkarim
 *
 */
public interface ArticleService {
  Integer create(ArticleEvent data);

  Integer update(Integer id, ArticleEvent data);

  Integer delete(Integer id);

  List<Article> findByAuthor(String name);

  Article findOne(Integer id);

  List<Article> findBetweenDates(String start, String end);

  List<Article> findByKeyWords(String keywords);
}
