package de.tomsandt.salesync.repository.db.impl;

import de.tomsandt.salesync.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    Sale findById(long id);
    Sale findByCustomerId(long id);
    Sale findByArticleId(long id);
    Sale findByStatus(String status);
    Sale findByAmount(int amount);
    Sale findByDate(LocalDate date);
    Sale findByPrice(double price);
    Sale findByFee(double fee);
    Sale findByTax(double tax);
}
