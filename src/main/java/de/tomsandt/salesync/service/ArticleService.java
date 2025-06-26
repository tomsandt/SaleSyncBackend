package de.tomsandt.salesync.service;


import de.tomsandt.salesync.domain.Article;
import de.tomsandt.salesync.repository.db.impl.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article getArticleById(long id) {
        return articleRepository.findById(id);
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(Article article, long id) {
        Article oldArticle = articleRepository.findById(id);
        if (oldArticle == null) {
            throw new EntityNotFoundException("Article with id" + id + "not found");
        }
        oldArticle.setName(article.getName());
        oldArticle.setName(article.getName());
        oldArticle.setDescription(article.getDescription());
        oldArticle.setType(article.getType());
        return articleRepository.save(oldArticle);
    }

    public void deleteArticle(long id) {
        Article oldArticle = articleRepository.findById(id);
        if (oldArticle == null){
            throw new EntityNotFoundException("Article with id" + id + "not found");
        }
        articleRepository.deleteById(id);
    }

}