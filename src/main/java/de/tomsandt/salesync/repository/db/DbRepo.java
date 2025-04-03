package de.tomsandt.salesync.repository.db;

import de.tomsandt.salesync.domain.*;
import de.tomsandt.salesync.repository.db.impl.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class DbRepo {

    private final CustomerRepository customerRepository;

    @Autowired
    public DbRepo(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Optional<Customer> getCustomerByEmail(String mail) {
        return Optional.ofNullable(customerRepository.findByMail(mail));
    }

    public Optional<Customer> getCustomerByLastName(String lastName) {
        return Optional.ofNullable(customerRepository.findByLastName(lastName));
    }

    public Optional<Customer> getCustomerByFirstName(String firstName) {
        return Optional.ofNullable(customerRepository.findByFirstName(firstName));
    }

    public Optional<Customer> getCustomerByPhone(String phone) {
        return Optional.ofNullable(customerRepository.findByPhone(phone));
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }
}
