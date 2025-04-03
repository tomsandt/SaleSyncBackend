package de.tomsandt.salesync.repository.db.impl;

import de.tomsandt.salesync.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByMail (String mail);
    Customer findByLastName(String lastName);
    Customer findByFirstName(String firstName);
    Customer findByZipCode(String zipCode);
    Customer findByStreet(String street);
    Customer findByCity(String city);
    Customer findById(long id);
    Customer findByPhone(String phone);
}
