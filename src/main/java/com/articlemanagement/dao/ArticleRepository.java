package com.articlemanagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.articlemanagement.model.Article;

/**
 * @author cnaik
 */
public interface ArticleRepository extends CrudRepository<Article, Long> {

}
