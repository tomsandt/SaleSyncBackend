package de.tomsandt.salesync.service;


import de.tomsandt.salesync.domain.Article;
import de.tomsandt.salesync.domain.Customer;
import de.tomsandt.salesync.domain.DTO.SaleDTO;
import de.tomsandt.salesync.domain.Dealer;
import de.tomsandt.salesync.domain.Sale;
import de.tomsandt.salesync.repository.db.impl.ArticleRepository;
import de.tomsandt.salesync.repository.db.impl.CustomerRepository;
import de.tomsandt.salesync.repository.db.impl.SaleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale createSale(SaleDTO dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer with ID "+dto.getCustomerId()+" not found"));

        Article article = articleRepository.findById(dto.getArticleId())
                .orElseThrow(() -> new EntityNotFoundException("Article with ID "+dto.getArticleId()+" not found"));

        Sale sale = new Sale();
        sale.setCustomer(customer);
        sale.setArticle(article);
        sale.setAmount(dto.getAmount());
        sale.setDate(dto.getDate());
        sale.setPrice(dto.getPrice());
        sale.setStatus(dto.getStatus());
        sale.setFee(dto.getFee());
        sale.setTax(dto.getTax());
        return saleRepository.save(sale);
    }

    public Sale updateSale(SaleDTO dto, long id) {
        Sale excistingSale = saleRepository.findById(id);
        if (excistingSale == null){
            throw new EntityNotFoundException("Sale with id " + id + " not found");
        }
        excistingSale.setAmount(dto.getAmount());
        excistingSale.setDate(dto.getDate());
        excistingSale.setPrice(dto.getPrice());
        excistingSale.setStatus(dto.getStatus());
        excistingSale.setFee(dto.getFee());
        excistingSale.setTax(dto.getTax());

        return saleRepository.save(excistingSale);
    }

    public void deleteSale(long id) {
        Sale excistingSale = saleRepository.findById(id);
        if (excistingSale == null){
            throw new EntityNotFoundException("Sale with id " + id + " not found");
        }
        saleRepository.delete(excistingSale);
    }
}
