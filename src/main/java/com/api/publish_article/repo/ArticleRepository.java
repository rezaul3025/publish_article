
package com.api.publish_article.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.publish_article.domain.Article;

/**
 * @author rkarim
 *
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
  List<Article> findByAuthor(String name);

  @Query(value = "SELECT * FROM article WHERE keywords LIKE %:keywords%", nativeQuery=true)
  List<Article> findByKeywordsIn(@Param("keywords") String keywords);

  @Query(value = "SELECT * FROM article WHERE publish_date BETWEEN  :start AND :end", nativeQuery=true)
  List<Article> findByPublishDateBetween(@Param("start")  LocalDateTime start, @Param("end")  LocalDateTime end);
}
