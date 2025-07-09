package de.tomsandt.salesync.service;


import de.tomsandt.salesync.domain.Article;
import de.tomsandt.salesync.domain.DTO.PurchaseDTO;
import de.tomsandt.salesync.domain.Purchase;
import de.tomsandt.salesync.repository.db.impl.ArticleRepository;
import de.tomsandt.salesync.repository.db.impl.PurchaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<Purchase> getAllPurchases(){
        return purchaseRepository.findAll();
    }

    public Purchase createPurchase(PurchaseDTO dto){

        Article article = articleRepository.findById(dto.getArticleId())
                .orElseThrow(() -> new EntityNotFoundException("Article with ID "+dto.getArticleId()+" not found"));

        Purchase purchase = new Purchase();
        purchase.setArticle(article);
        purchase.setType(dto.getType());
        purchase.setStatus(dto.getStatus());
        purchase.setAmount(dto.getAmount());
        purchase.setDate(dto.getDate());
        purchase.setTax(dto.getTax());
        purchase.setShipping(dto.getShipping());
        purchase.setPrice(dto.getPrice());

        return purchaseRepository.save(purchase);
    }

    public Purchase updatePurchase(PurchaseDTO dto, long id){
        Purchase existingPurchase = purchaseRepository.findById(id);
        if(existingPurchase == null){
            throw new EntityNotFoundException("Purchase with id " + id + " not found");
        }
        existingPurchase.setType(dto.getType());
        existingPurchase.setStatus(dto.getStatus());
        existingPurchase.setAmount(dto.getAmount());
        existingPurchase.setDate(dto.getDate());
        existingPurchase.setTax(dto.getTax());
        existingPurchase.setShipping(dto.getShipping());
        existingPurchase.setPrice(dto.getPrice());
        return purchaseRepository.save(existingPurchase);
    }
    public void deletePurchase(long id){
        Purchase existingPurchase = purchaseRepository.findById(id);
        if(existingPurchase == null){
            throw new EntityNotFoundException("Purchase with id " + id + " not found");
        }
        purchaseRepository.delete(existingPurchase);
    }

}
