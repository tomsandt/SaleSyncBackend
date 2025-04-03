package de.tomsandt.salesync.controller;
import de.tomsandt.salesync.repository.db.DbRepo;
import de.tomsandt.salesync.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/frontend")
public class FrontendController {

    private final DbRepo dbRepo;

    @Autowired
    public FrontendController(DbRepo dbRepo) {
        this.dbRepo = dbRepo;
    }

    @GetMapping("/v1/customer")
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(dbRepo.getAllCustomers());
    }

    @PostMapping("/v1/customer")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok("200");
    }

    @GetMapping("/v1/customer/{id}")
    public ResponseEntity<String> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok("200");
    }

    @PutMapping("/v1/customer/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return ResponseEntity.ok("Customer with ID " + id + " updated");
    }

    @DeleteMapping("/v1/customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        return ResponseEntity.ok("Customer with ID " + id + " deleted");
    }

    @GetMapping("/v1/dealer")
    public ResponseEntity<String> getDealers() {
        return ResponseEntity.ok("200");
    }

    @PostMapping("/v1/dealer")
    public ResponseEntity<String> addDealer(@RequestBody Dealer dealer) {
        return ResponseEntity.ok("200");
    }

    @GetMapping("/v1/dealer/{id}")
    public ResponseEntity<String> getDealer(@PathVariable Long id) {
        return ResponseEntity.ok("200");
    }

    @PutMapping("/v1/dealer/{id}")
    public ResponseEntity<String> updateDealer(@PathVariable Long id, @RequestBody Dealer dealer) {
        return ResponseEntity.ok("Customer with ID" + id + "updated");
    }

    @DeleteMapping("/v1/dealer/{id}")
    public ResponseEntity<String> deleteDealer(@PathVariable Long id) {
        return ResponseEntity.ok("Customer with ID" + id + " deleted");
    }

    @GetMapping("/v1/article")
    public ResponseEntity<String> getArticles() {
        return ResponseEntity.ok("200");
    }

    @PostMapping("/v1/article")
    public ResponseEntity<String> addArticle(@RequestBody Article article) {
        return ResponseEntity.ok("200");
    }

    @GetMapping("/v1/article/{id}")
    public ResponseEntity<String> getArticle(@PathVariable Long id) {
        return ResponseEntity.ok("200");
    }

    @PutMapping("/v1/article/{id}")
    public ResponseEntity<String> updateArticle(@PathVariable Long id, @RequestBody Article article) {
        return ResponseEntity.ok("Customer with ID" + id + "updated");
    }

    @DeleteMapping("/v1/article/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
        return ResponseEntity.ok("Customer with ID" + id + " deleted");
    }

    @GetMapping("/v1/purchase")
    public ResponseEntity<String> getPurchases() {
        return ResponseEntity.ok("200");
    }

    @PostMapping("/v1/purchase")
    public ResponseEntity<String> addPurchase(@RequestBody Purchase purchase) {
        return ResponseEntity.ok("200");
    }

    @GetMapping("/v1/purchase/{id}")
    public ResponseEntity<String> getPurchase(@PathVariable Long id) {
        return ResponseEntity.ok("200");
    }

    @PutMapping("/v1/purchase/{id}")
    public ResponseEntity<String> updatePurchase(@PathVariable Long id, @RequestBody Purchase purchase) {
        return ResponseEntity.ok("Customer with ID" + id + "updated");
    }

    @DeleteMapping("/v1/purchase/{id}")
    public ResponseEntity<String> deletePurchase(@PathVariable Long id) {
        return ResponseEntity.ok("Customer with ID" + id + " deleted");
    }

    @GetMapping ("/v1/sale")
    public ResponseEntity<String> getSales() {
        return ResponseEntity.ok("200");
    }

    @PostMapping("/v1/sale")
    public ResponseEntity<String> addSale(@RequestBody Sale sale) {
        return ResponseEntity.ok("200");
    }

    @GetMapping("/v1/sale/{id}")
    public ResponseEntity<String> getSale(@PathVariable Long id) {
        return ResponseEntity.ok("200");
    }

    @PutMapping("/v1/sale/{id}")
    public ResponseEntity<String> updateSale(@PathVariable Long id, @RequestBody Sale sale) {
        return ResponseEntity.ok("Customer with ID" + id + "updated");
    }

    @DeleteMapping("/v1/sale/{id}")
    public ResponseEntity<String> deleteSale(@PathVariable Long id) {
        return ResponseEntity.ok("Customer with ID" + id + " deleted");
    }
}

