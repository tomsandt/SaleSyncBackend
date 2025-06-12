package de.tomsandt.salesync.controller;
import de.tomsandt.salesync.domain.*;
import de.tomsandt.salesync.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Provider;
import java.util.List;

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
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/v1/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PutMapping("/v1/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @DeleteMapping("/v1/customer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/v1/dealer")
    public ResponseEntity<List<Dealer>> getAllDealers() {
        return ResponseEntity.ok(dealerService.getAllDealers());
    }

    @PostMapping("/v1/dealer")
    public ResponseEntity<Dealer> createDealer(@RequestBody Dealer dealer) {
        Dealer newDealer = dealerService.createDealer(dealer);
        return new ResponseEntity<>(newDealer, HttpStatus.CREATED);
    }

    @GetMapping("/v1/dealer/{id}")
    public ResponseEntity<Dealer> getDealer(@PathVariable long id) {
        return ResponseEntity.ok(dealerService.getDealerById(id));
    }

    @PutMapping("/v1/dealer/{id}")
    public ResponseEntity<Dealer> updateDealer(@PathVariable long id, @RequestBody Dealer dealer) {
        return ResponseEntity.ok(dealerService.updateDealer(dealer, id));
    }

    @DeleteMapping("/v1/dealer/{id}")
    public ResponseEntity<Void> deleteDealer(@PathVariable Long id) {
        dealerService.deleteDealer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/v1/article")
    public ResponseEntity<List<Article>> getArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @PostMapping("/v1/article")
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
        Article newArticle = articleService.createArticle(article);
        return new ResponseEntity<>(newArticle, HttpStatus.CREATED);
    }

    @GetMapping("/v1/article/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable long id) {
        return ResponseEntity.ok(articleService.getArticleById(id));
    }

    @PutMapping("/v1/article/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody Article article) {
        return ResponseEntity.ok(articleService.updateArticle(article, id));
    }

    @DeleteMapping("/v1/article/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/v1/purchase")
    public ResponseEntity<List<Purchase>> getPurchases() {
        return ResponseEntity.ok(purchaseService.getAllPurchases());
    }

    @PostMapping("/v1/purchase")
    public ResponseEntity<Purchase> addPurchase(@RequestBody Purchase purchase) {
        Purchase newPurchase = purchaseService.createPurchase(purchase);
        return new ResponseEntity<>(newPurchase, HttpStatus.CREATED);
    }

    @GetMapping("/v1/purchase/{id}")
    public ResponseEntity<Purchase> getPurchase(@PathVariable long id) {
        return ResponseEntity.ok(purchaseService.getPurchaseById(id));
    }

    @PutMapping("/v1/purchase/{id}")
    public ResponseEntity<Purchase> updatePurchase(@PathVariable long id, @RequestBody Purchase purchase) {
        return ResponseEntity.ok(purchaseService.updatePurchase(purchase, id));
    }

    @DeleteMapping("/v1/purchase/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable long id) {
        purchaseService.deletePurchase(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping ("/v1/sale")
    public ResponseEntity<List<Sale>> getSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    @PostMapping("/v1/sale")
    public ResponseEntity<Sale> addSale(@RequestBody Sale sale) {
        Sale newSale = saleService.createSale(sale);
        return new ResponseEntity<>(newSale, HttpStatus.CREATED);
    }

    @GetMapping("/v1/sale/{id}")
    public ResponseEntity<Sale> getSale(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.getSaleById(id));
    }

    @PutMapping("/v1/sale/{id}")
    public ResponseEntity<Sale> updateSale(@PathVariable long id, @RequestBody Sale sale) {
        return ResponseEntity.ok(saleService.updateSale(sale, id));
    }

    @DeleteMapping("/v1/sale/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable long id) {
        saleService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }
}

