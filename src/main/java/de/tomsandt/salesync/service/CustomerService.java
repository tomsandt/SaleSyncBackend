package de.tomsandt.salesync.service;


import de.tomsandt.salesync.domain.Customer;
import de.tomsandt.salesync.repository.db.impl.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(long id) {
        return customerRepository.findById(id);
    }

    public Customer updateCustomer(long id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(id);
        if (existingCustomer == null) {
            throw new EntityNotFoundException("Customer with id " + id + " not found");
        }
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setStreet(customer.getStreet());
        existingCustomer.setCity(customer.getCity());
        existingCustomer.setZipCode(customer.getZipCode());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setMail(customer.getMail());

        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomer(long id) {
        Customer existingCustomer = customerRepository.findById(id);
        if (existingCustomer == null) {
            throw new EntityNotFoundException("Customer with id " + id + " not found");
        }
        customerRepository.delete(existingCustomer);
    }


}
