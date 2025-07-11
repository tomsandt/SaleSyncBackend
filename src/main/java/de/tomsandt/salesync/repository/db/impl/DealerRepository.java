package de.tomsandt.salesync.repository.db.impl;

import de.tomsandt.salesync.domain.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealerRepository extends JpaRepository<Dealer, Long>{
    boolean existsByMail(String mail);
    Dealer findById (long id);
    Dealer findByName (String name);
    Dealer findByMail (String mail);
    Dealer findByPhone (String phone);
    Dealer findByType (String type);
    Dealer findByCity (String city);
    Dealer findByStreet (String street);
    Dealer findByZipCode (String zipCode);
}
