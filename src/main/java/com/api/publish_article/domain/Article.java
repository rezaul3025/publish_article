/*******************************************************************************
 * (c) Copyright 1997-2015, CENTOGENE AG
 *
 *  All rights reserved. This work contains unpublished proprietary information
 *  of CENTOGENE AG and is copy protected by law. It may not
 *  be disclosed to third parties or copied or duplicated in any form, in whole
 *  or in part, without the specific written permission of CENTOGENE AG.
 *  
 *******************************************************************************/
package com.api.publish_article.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author rkarim
 *
 */
@Entity(name = "article")
public class Article {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  private String header;
  
  private String description;
  
  private String text;
  
  @Column(name="publish_date")
  private LocalDateTime publishDate;
  
  private String author;
  
  private String keywords;
  
  public Article()
  {
    
  }
  
  public Article(String header, String description, String text, LocalDateTime publishDate,
      String author, String keywords) {
    
    this.header = header;
    this.description = description;
    this.text = text;
    this.publishDate = publishDate;
    this.author = author;
    this.keywords = keywords;
  }

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return the header
   */
  public String getHeader() {
    return header;
  }

  /**
   * @param header the header to set
   */
  public void setHeader(String header) {
    this.header = header;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * @param text the text to set
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * @return the publishDate
   */
  public LocalDateTime getPublishDate() {
    return publishDate;
  }

  /**
   * @param publishDate the publishDate to set
   */
  public void setPublishDate(LocalDateTime publishDate) {
    this.publishDate = publishDate;
  }

  /**
   * @return the author
   */
  public String getAuthor() {
    return author;
  }

  /**
   * @param author the author to set
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * @return the keywords
   */
  public String getKeywords() {
    return keywords;
  }

  /**
   * @param keywords the keywords to set
   */
  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }
  
  
}
