package com.articlemanagement.controllers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.articlemanagement.model.Article;

/**
 * @author cnaik
 */
@RestController
@RequestMapping("/")
public class HomeController {
    private static final Logger logger = Logger.getLogger(ArticleController.class);

    private static final String TITLE = "Hello, Welcome to Article Management";

    /**
     * @param name
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Article> greeting() {
        logger.debug("Inside HomeController..");
        return new ResponseEntity<>(new Article(1, TITLE, "Go to /articles", "Rest User"), HttpStatus.OK);
    }
}
