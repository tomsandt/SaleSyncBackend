package de.tomsandt.salesync.service;


import de.tomsandt.salesync.domain.Dealer;
import de.tomsandt.salesync.repository.db.impl.DealerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DealerService {

    @Autowired
    private DealerRepository dealerRepository;

    public Dealer getDealerById(long id) {
        return dealerRepository.findById(id);
    }

    public List<Dealer> getAllDealers() {
        return dealerRepository.findAll();
    }

    public Dealer createDealer(Dealer dealer) {
        if (dealerRepository.existsByMail(dealer.getMail())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Dealer with mail "+dealer.getMail()+" already exists");
        }
        return dealerRepository.save(dealer);
    }

    public Dealer updateDealer(Dealer dealer, long id) {
        Dealer excistingDealer = dealerRepository.findById(id);
        if (excistingDealer == null) {
            throw new EntityNotFoundException("Dealer with id" + id + "not found");
        }
        excistingDealer.setCity(excistingDealer.getCity());
        excistingDealer.setName(excistingDealer.getName());
        excistingDealer.setStreet(excistingDealer.getStreet());
        excistingDealer.setZipCode(excistingDealer.getZipCode());
        excistingDealer.setPhone(excistingDealer.getPhone());
        excistingDealer.setMail(excistingDealer.getMail());
        excistingDealer.setType(excistingDealer.getType());

        return dealerRepository.save(dealer);
    }
    public void deleteDealer(long id) {
        Dealer excistingDealer = dealerRepository.findById(id);
        if (excistingDealer == null) {
            throw new EntityNotFoundException("Dealer with id" + id + "not found");
        }
        dealerRepository.delete(excistingDealer);
    }



}
