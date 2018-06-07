package com.controllers;


import com.DTOs.ArticleDTO;
import com.DTOs.UserDTO;
import com.domain_services.AdminDomainService;
import com.domain_services.AdminDomainServiceImpl;
import com.domain_services.CustomerDomainService;
import com.domain_services.UserDomainService;
import com.entities.Article;
import com.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(value= "api/article")
public class ArticleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDomainService userService;

    @Autowired
    private CustomerDomainService customerDomainService;

    @Autowired
    private AdminDomainService adminDomainService;

    @RequestMapping(value = "/addArticle",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> addArticle(@RequestBody ArticleDTO articleDTO) {

        logger.info("> create article");

        Article retArticle = adminDomainService.addArticle(articleDTO);

        if (retArticle == null) {
            System.out.println(" article not created");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        logger.info("< register article");
        System.out.println("article successfully created");

        return new ResponseEntity<>(retArticle, HttpStatus.OK);
    }

    @RequestMapping(value = "/removeArticle",
            method = RequestMethod.DELETE)
    public ResponseEntity<Article> removeMealItemFromMenu(ArticleDTO articleDTO) {

        logger.info("> remove article from list");

        Article retArticle = adminDomainService.removeArticle(articleDTO);

        if (retArticle == null) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        logger.info("> remove article from list");

        return new ResponseEntity<>(retArticle, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll",
            method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Article>> getAll() {

        logger.info("> get articles ");

        ArrayList<Article> articles = adminDomainService.getAll();

        if (articles == null) {
            logger.info("articles not returned");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        System.out.println(articles.size());
        logger.info("< get articles;");

        return new ResponseEntity<>(articles, HttpStatus.OK);
    }
}
