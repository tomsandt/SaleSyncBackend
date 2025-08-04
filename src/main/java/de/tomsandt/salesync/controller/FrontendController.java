package de.tomsandt.salesync.controller;
import de.tomsandt.salesync.domain.*;
import de.tomsandt.salesync.service.*;
import de.tomsandt.salesync.domain.DTO.*;
import jakarta.persistence.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Provider;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/frontend")
public class FrontendController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ArticleService articleService;

    @Autowired
    DealerService dealerService;

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    SaleService saleService;


    @GetMapping("/v1/customer")
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PostMapping("/v1/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO dto) {
        Customer newCustomer = customerService.createCustomer(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }


    @PutMapping("/v1/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody CustomerDTO dto) {
        Customer updatedCustomer = customerService.updateCustomer(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCustomer);
    }


    @DeleteMapping("/v1/customer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/v1/dealer")
    public ResponseEntity<List<Dealer>> getAllDealers() {
        return ResponseEntity.ok(dealerService.getAllDealers());
    }

    @PostMapping("/v1/dealer")
    public ResponseEntity<Dealer> createDealer(@RequestBody DealerDTO dto) {
        Dealer newDealer = dealerService.createDealer(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDealer);
    }

    @PutMapping("/v1/dealer/{id}")
    public ResponseEntity<Dealer> updateDealer(@PathVariable long id, @RequestBody DealerDTO dto) {
        Dealer updatedDealer = dealerService.updateDealer(dto, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDealer);
    }

    @DeleteMapping("/v1/dealer/{id}")
    public ResponseEntity<Void> deleteDealer(@PathVariable long id) {
        dealerService.deleteDealer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/v1/article")
    public ResponseEntity<List<Article>> getArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @PostMapping("/v1/article")
    public ResponseEntity<Article> addArticle(@RequestBody ArticleDTO dto) {
        Article newArticle = articleService.createArticle(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newArticle);
    }

    @PutMapping("/v1/article/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody ArticleDTO dto) {
        Article updatedArticle = articleService.updateArticle(dto, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedArticle);
    }

    @DeleteMapping("/v1/article/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/v1/purchase")
    public ResponseEntity<List<Purchase>> getPurchases() {
        return ResponseEntity.ok(purchaseService.getAllPurchases());
    }

    @PostMapping("/v1/purchase")
    public ResponseEntity<Purchase> addPurchase(@RequestBody PurchaseDTO dto) {
        Purchase newPurchase = purchaseService.createPurchase(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPurchase);
    }

    @PutMapping("/v1/purchase/{id}")
    public ResponseEntity<Purchase> updatePurchase(@PathVariable long id, @RequestBody PurchaseDTO dto) {
        Purchase updatedPurchase = purchaseService.updatePurchase(dto, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedPurchase);
    }

    @DeleteMapping("/v1/purchase/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable long id) {
        purchaseService.deletePurchase(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping ("/v1/sale")
    public ResponseEntity<List<Sale>> getSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    @PostMapping("/v1/sale")
    public ResponseEntity<Sale> addSale(@RequestBody SaleDTO dto) {
        Sale newSale = saleService.createSale(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSale);
    }

    @PutMapping("/v1/sale/{id}")
    public ResponseEntity<Sale> updateSale(@PathVariable long id, @RequestBody SaleDTO dto) {
        Sale updatedSale = saleService.updateSale(dto, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedSale);
    }

    @DeleteMapping("/v1/sale/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable long id) {
        saleService.deleteSale(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

