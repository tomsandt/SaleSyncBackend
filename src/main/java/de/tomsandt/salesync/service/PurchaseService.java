package de.tomsandt.salesync.service;


import de.tomsandt.salesync.domain.Purchase;
import de.tomsandt.salesync.repository.db.impl.PurchaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAllPurchases(){
        return purchaseRepository.findAll();
    }

    public Purchase getPurchaseById(long id){
        return purchaseRepository.findById(id);
    }

    public Purchase createPurchase(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

    public Purchase updatePurchase(Purchase purchase, long id){
        Purchase existingPurchase = purchaseRepository.findById(id);
        if(existingPurchase == null){
            throw new EntityNotFoundException("Purchase with id " + id + " not found");
        }
        existingPurchase.setType(purchase.getType());
        existingPurchase.setStatus(purchase.getStatus());
        existingPurchase.setAmount(purchase.getAmount());
        existingPurchase.setDate(purchase.getDate());
        existingPurchase.setTax(purchase.getTax());
        existingPurchase.setShipping(purchase.getShipping());
        existingPurchase.setPrice(purchase.getPrice());
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
