package com.articlemanagement.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author cnaik
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.articlemanagement.*" })
@ComponentScan(basePackages = { "com.articlemanagement.*" })
@EntityScan("com.articlemanagement.*")
public class Application {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
