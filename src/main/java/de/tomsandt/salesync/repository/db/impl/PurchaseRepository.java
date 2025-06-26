package de.tomsandt.salesync.repository.db.impl;

import de.tomsandt.salesync.domain.Article;
import de.tomsandt.salesync.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    Purchase findById(long id);
    Purchase findByType(String type);
    Purchase findByArticle(Article article);
    Purchase findByStatus(String status);
    Purchase findByAmount(int amount);
    Purchase findByPrice(double price);
    Purchase findByShipping(double shipping);
    Purchase findByTax(double tax);
    Purchase findByDate(LocalDate date);
}
