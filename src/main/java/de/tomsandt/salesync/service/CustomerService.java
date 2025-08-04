package de.tomsandt.salesync.service;

import de.tomsandt.salesync.domain.DTO.CustomerDTO;
import de.tomsandt.salesync.domain.Customer;
import de.tomsandt.salesync.repository.db.impl.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(CustomerDTO dto) {
        if (customerRepository.existsByMail(dto.getMail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Customer with Mail "+dto.getMail()+" already exists");
        }

        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setStreet(dto.getStreet());
        customer.setCity(dto.getCity());
        customer.setZipCode(dto.getZipCode());
        customer.setPhone(dto.getPhone());
        customer.setMail(dto.getMail());

        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer updateCustomer(long id, CustomerDTO dto) {
        Customer existingCustomer = customerRepository.findById(id);
        if (existingCustomer == null) {
            throw new EntityNotFoundException("Customer with id " + id + " not found");
        }
        existingCustomer.setFirstName(dto.getFirstName());
        existingCustomer.setLastName(dto.getLastName());
        existingCustomer.setStreet(dto.getStreet());
        existingCustomer.setCity(dto.getCity());
        existingCustomer.setZipCode(dto.getZipCode());
        existingCustomer.setPhone(dto.getPhone());
        existingCustomer.setMail(dto.getMail());

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