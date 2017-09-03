package com.articlemanagement.controllers;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.articlemanagement.dao.ArticleRepository;
import com.articlemanagement.model.Article;

/**
 * @author cnaik
 */
@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    private static final Logger logger = Logger.getLogger(ArticleController.class);

    @Autowired
    DataSource dataSource;

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * @return
     */
    @RequestMapping(path = "/articles", method = RequestMethod.GET)
    public ResponseEntity<List<Article>> getArticles() {
        List<Article> articles = (List<Article>) articleRepository.findAll();
        if (CollectionUtils.isEmpty(articles)) {
            logger.debug("Articles does not exists");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + articles.size() + " Employees");
        logger.debug(articles);
        logger.debug(Arrays.toString(articles.toArray()));
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    /**
     * @param article
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Article> addArticles(@RequestBody Article article) {
        articleRepository.save(article);
        logger.debug("Added:: " + article);
        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

    /**
     * @param article
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateEmployee(@RequestBody Article article) {
        Article existingArticle = articleRepository.findOne((long) article.getId());
        if (existingArticle == null) {
            logger.debug("Article with id " + article.getId() + " does not exist..");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            articleRepository.save(article);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    /**
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") long id) {
        if (articleRepository.findOne(id) != null) {
            logger.debug("Article with id " + id + " deleted");
            articleRepository.delete(id);
            return new ResponseEntity<>(HttpStatus.GONE);
        } else
            logger.debug("Article with id " + id + " does not exist");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
