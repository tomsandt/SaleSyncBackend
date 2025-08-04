package de.tomsandt.salesync.service;


import de.tomsandt.salesync.domain.Article;
import de.tomsandt.salesync.domain.DTO.ArticleDTO;
import de.tomsandt.salesync.domain.Dealer;
import de.tomsandt.salesync.repository.db.impl.ArticleRepository;
import de.tomsandt.salesync.repository.db.impl.DealerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private DealerRepository dealerRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article createArticle(ArticleDTO dto) {

        Dealer dealer = dealerRepository.findById(dto.getDealerId())
                .orElseThrow(() -> new EntityNotFoundException("Dealer with ID "+ dto.getDealerId()+" not found"));

        Article article = new Article();
        article.setDealer(dealer);
        article.setName(dto.getName());
        article.setName(dto.getName());
        article.setDescription(dto.getDescription());
        article.setType(dto.getType());
        return articleRepository.save(article);

    }

    public Article updateArticle(ArticleDTO dto, long id) {
        Article oldArticle = articleRepository.findById(id);
        if (oldArticle == null) {
            throw new EntityNotFoundException("Article with id " + id + " not found");
        }
        oldArticle.setName(dto.getName());
        oldArticle.setName(dto.getName());
        oldArticle.setDescription(dto.getDescription());
        oldArticle.setType(dto.getType());
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