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

import org.springframework.stereotype.Service;

import com.api.publish_article.domain.Article;
import com.api.publish_article.event.ArticleEvent;

/**
 * @author rkarim
 *
 */
@Service
public class ArticleServiceHandler implements ArticleService{

  /* (non-Javadoc)
   * @see com.api.publish_article.service.ArticleService#create(com.api.publish_article.event.ArticleEvent)
   */
  @Override
  public Integer create(ArticleEvent data) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.api.publish_article.service.ArticleService#update(java.lang.Integer, com.api.publish_article.event.ArticleEvent)
   */
  @Override
  public Integer update(Integer id, ArticleEvent data) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.api.publish_article.service.ArticleService#delete(java.lang.Integer)
   */
  @Override
  public void delete(Integer id) {
    // TODO Auto-generated method stub
    
  }

  /* (non-Javadoc)
   * @see com.api.publish_article.service.ArticleService#findByAuthor(java.lang.String)
   */
  @Override
  public List<Article> findByAuthor(String name) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.api.publish_article.service.ArticleService#findOne(java.lang.Integer)
   */
  @Override
  public Article findOne(Integer id) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.api.publish_article.service.ArticleService#findBetweenDates(java.time.LocalDateTime, java.time.LocalDateTime)
   */
  @Override
  public List<Article> findBetweenDates(LocalDateTime start, LocalDateTime end) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.api.publish_article.service.ArticleService#findByKeyWords(java.lang.String)
   */
  @Override
  public List<Article> findByKeyWords(String keywords) {
    // TODO Auto-generated method stub
    return null;
  }

}
