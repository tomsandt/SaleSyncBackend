package de.tomsandt.salesync.controller;
import de.tomsandt.salesync.domain.*;
import de.tomsandt.salesync.service.*;
import jakarta.persistence.Id;
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
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.createCustomer(customer);
        long id = newCustomer.getId();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Customer with id: " + id + " created");
    }

    @GetMapping("/v1/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PutMapping("/v1/customer/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Customer with id: " +id+ " successfully updated" );
    }

    @DeleteMapping("/v1/customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Customer with id "+id+" successfully deleted");
    }

    @GetMapping("/v1/dealer")
    public ResponseEntity<List<Dealer>> getAllDealers() {
        return ResponseEntity.ok(dealerService.getAllDealers());
    }

    @PostMapping("/v1/dealer")
    public ResponseEntity<String> createDealer(@RequestBody Dealer dealer) {
        Dealer newDealer = dealerService.createDealer(dealer);
        long id = newDealer.getId();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Dealer with id: " + id + " created");
    }

    @GetMapping("/v1/dealer/{id}")
    public ResponseEntity<Dealer> getDealer(@PathVariable long id) {
        return ResponseEntity.ok(dealerService.getDealerById(id));
    }

    @PutMapping("/v1/dealer/{id}")
    public ResponseEntity<String> updateDealer(@PathVariable long id, @RequestBody Dealer dealer) {
        dealerService.updateDealer(dealer, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Dealer with id: " +id+ " successfully updated");
    }

    @DeleteMapping("/v1/dealer/{id}")
    public ResponseEntity<String> deleteDealer(@PathVariable Long id) {
        dealerService.deleteDealer(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Dealer with id: " +id+ " successfully updated");
    }

    @GetMapping("/v1/article")
    public ResponseEntity<List<Article>> getArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @PostMapping("/v1/article")
    public ResponseEntity<String> addArticle(@RequestBody Article article) {
        Article newArticle = articleService.createArticle(article);
        long id = newArticle.getId();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Article with id: " + id + " created");
    }

    @GetMapping("/v1/article/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable long id) {
        return ResponseEntity.ok(articleService.getArticleById(id));
    }

    @PutMapping("/v1/article/{id}")
    public ResponseEntity<String> updateArticle(@PathVariable long id, @RequestBody Article article) {
        articleService.updateArticle(article, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Article with id: " + id + " successfully updated");
    }

    @DeleteMapping("/v1/article/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Article with id: " + id + " successfully deleted");
    }

    @GetMapping("/v1/purchase")
    public ResponseEntity<List<Purchase>> getPurchases() {
        return ResponseEntity.ok(purchaseService.getAllPurchases());
    }

    @PostMapping("/v1/purchase")
    public ResponseEntity<String> addPurchase(@RequestBody Purchase purchase) {
        Purchase newPurchase = purchaseService.createPurchase(purchase);
        long id = newPurchase.getId();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Purchase with id: " + id + " created");
    }

    @GetMapping("/v1/purchase/{id}")
    public ResponseEntity<Purchase> getPurchase(@PathVariable long id) {
        return ResponseEntity.ok(purchaseService.getPurchaseById(id));
    }

    @PutMapping("/v1/purchase/{id}")
    public ResponseEntity<String> updatePurchase(@PathVariable long id, @RequestBody Purchase purchase) {
        purchaseService.updatePurchase(purchase, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Purchase with id: " + id + " successfully updated");
    }

    @DeleteMapping("/v1/purchase/{id}")
    public ResponseEntity<String> deletePurchase(@PathVariable long id) {
        purchaseService.deletePurchase(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Purchase with id: " + id + " successfully deleted");
    }

    @GetMapping ("/v1/sale")
    public ResponseEntity<List<Sale>> getSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    @PostMapping("/v1/sale")
    public ResponseEntity<String> addSale(@RequestBody Sale sale) {
        Sale newSale = saleService.createSale(sale);
        long id = newSale.getId();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Sale with id: " + id + " created");
    }

    @GetMapping("/v1/sale/{id}")
    public ResponseEntity<Sale> getSale(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.getSaleById(id));
    }

    @PutMapping("/v1/sale/{id}")
    public ResponseEntity<String> updateSale(@PathVariable long id, @RequestBody Sale sale) {
        saleService.updateSale(sale, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Sale with id: " + id + " successfully updated");
    }

    @DeleteMapping("/v1/sale/{id}")
    public ResponseEntity<String> deleteSale(@PathVariable long id) {
        saleService.deleteSale(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Sale with id: " + id + " successfully deleted");
    }
}

