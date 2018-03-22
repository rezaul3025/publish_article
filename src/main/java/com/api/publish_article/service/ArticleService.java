/*******************************************************************************
 * (c) Copyright 1997-2015, CENTOGENE AG
 *
 *  All rights reserved. This work contains unpublished proprietary information
 *  of CENTOGENE AG and is copy protected by law. It may not
 *  be disclosed to third parties or copied or duplicated in any form, in whole
 *  or in part, without the specific written permission of CENTOGENE AG.
 *  
 *******************************************************************************/
package com.api.publish_article.service;

import java.time.LocalDateTime;
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

  void delete(Integer id);

  List<Article> findByAuthor(String name);

  Article findOne(Integer id);

  List<Article> findBetweenDates(LocalDateTime start, LocalDateTime end);

  List<Article> findByKeyWords(String keywords);
}
