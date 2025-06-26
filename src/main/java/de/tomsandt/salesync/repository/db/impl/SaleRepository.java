package de.tomsandt.salesync.repository.db.impl;

import de.tomsandt.salesync.domain.Article;
import de.tomsandt.salesync.domain.Customer;
import de.tomsandt.salesync.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    Sale findById(long id);
    Sale findByCustomer(Customer customer);
    Sale findByArticle(Article article);
    Sale findByStatus(String status);
    Sale findByAmount(int amount);
    Sale findByDate(LocalDate date);
    Sale findByPrice(double price);
    Sale findByFee(double fee);
    Sale findByTax(double tax);
}
