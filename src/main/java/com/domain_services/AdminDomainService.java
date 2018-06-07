package com.domain_services;

import com.DTOs.ArticleDTO;
import com.entities.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface AdminDomainService {

    Article addArticle(ArticleDTO articleDTO);

    Article removeArticle(ArticleDTO articleDTO);

    ArrayList<Article> getAll();

}
