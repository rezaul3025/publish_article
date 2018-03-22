/*******************************************************************************
 * (c) Copyright 1997-2015, CENTOGENE AG
 *
 *  All rights reserved. This work contains unpublished proprietary information
 *  of CENTOGENE AG and is copy protected by law. It may not
 *  be disclosed to third parties or copied or duplicated in any form, in whole
 *  or in part, without the specific written permission of CENTOGENE AG.
 *  
 *******************************************************************************/
package com.api.publish_article.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.publish_article.domain.Article;
import com.api.publish_article.event.ArticleEvent;

/**
 * @author rkarim
 *
 */
@RestController
@RequestMapping(value="/api/v1/article")
public class ArticleController {
  
  @RequestMapping(value="/create", method=RequestMethod.POST)
  public Integer create(@RequestBody ArticleEvent data){
    return 0;
  }
  
  @RequestMapping(value="/{id}/update", method=RequestMethod.POST)
  public Integer update(@PathVariable("id") Integer id,@RequestBody ArticleEvent data){
    return 0;
  }
  
  @RequestMapping(value="/{id}/delete", method=RequestMethod.DELETE)
  public void delete(@PathVariable("id") Integer id){
    
  }
  
  @RequestMapping(value="/author/{name}", method=RequestMethod.GET)
  public List<Article> findByAuthor(@PathVariable("name") String name){
    return null;
  }
  
  @RequestMapping(value="/findone/{id}", method=RequestMethod.GET)
  public Article findOne(@PathVariable("id") Integer id){
    return null;
  }
  
  @RequestMapping(value="/findbetween", method=RequestMethod.GET)
  public List<Article> findBetweenDates(@RequestParam("start") LocalDateTime start, @RequestParam("end") LocalDateTime end){
    return null;
  }
  
  @RequestMapping(value="/findkeywords", method=RequestMethod.GET)
  public List<Article> findByKeyWords(@RequestParam("keywords") String keywords){
    return null;
  }

}
