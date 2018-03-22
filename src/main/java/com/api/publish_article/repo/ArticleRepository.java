/*******************************************************************************
 * (c) Copyright 1997-2015, CENTOGENE AG
 *
 *  All rights reserved. This work contains unpublished proprietary information
 *  of CENTOGENE AG and is copy protected by law. It may not
 *  be disclosed to third parties or copied or duplicated in any form, in whole
 *  or in part, without the specific written permission of CENTOGENE AG.
 *  
 *******************************************************************************/
package com.api.publish_article.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.publish_article.domain.Article;

/**
 * @author rkarim
 *
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
