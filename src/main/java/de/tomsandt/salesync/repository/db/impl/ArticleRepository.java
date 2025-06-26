package de.tomsandt.salesync.repository.db.impl;

import de.tomsandt.salesync.domain.Article;
import de.tomsandt.salesync.domain.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findById(long id);
    Article findByDealer(Dealer dealer);
    Article findByType(String type);
    Article findByName(String name);
    Article findByDescription(String description);
}
