package de.tomsandt.salesync.service;


import de.tomsandt.salesync.domain.Dealer;
import de.tomsandt.salesync.domain.Sale;
import de.tomsandt.salesync.repository.db.impl.SaleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale getSaleById(long id) {
        return saleRepository.findById(id);
    }

    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale updateSale(Sale sale, long id) {
        Sale excistingSale = saleRepository.findById(id);
        if (excistingSale == null){
            throw new EntityNotFoundException("Sale with id " + id + " not found");
        }
        excistingSale.setArticleId(sale.getArticleId());
        excistingSale.setCustomerId(sale.getCustomerId());
        excistingSale.setAmount(sale.getAmount());
        excistingSale.setDate(sale.getDate());
        excistingSale.setPrice(sale.getPrice());
        excistingSale.setStatus(sale.getStatus());
        excistingSale.setFee(sale.getFee());
        excistingSale.setTax(sale.getTax());

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
