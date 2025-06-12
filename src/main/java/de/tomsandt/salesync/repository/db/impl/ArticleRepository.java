package de.tomsandt.salesync.repository.db.impl;

import de.tomsandt.salesync.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findById(long id);
    Article findByType(String type);
    Article findByDealerId(String dealerId);
    Article findByName(String name);
    Article findByDescription(String description);
}
