package de.tomsandt.salesync.service;


import de.tomsandt.salesync.domain.DTO.DealerDTO;
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

    public List<Dealer> getAllDealers() {
        return dealerRepository.findAll();
    }

    public Dealer createDealer(DealerDTO dto) {
        if (dealerRepository.existsByMail(dto.getMail())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Dealer with mail "+dto.getMail()+" already exists");
        }
        Dealer dealer = new Dealer();
        dealer.setCity(dto.getCity());
        dealer.setName(dto.getName());
        dealer.setStreet(dto.getStreet());
        dealer.setZipCode(dto.getZipCode());
        dealer.setPhone(dto.getPhone());
        dealer.setMail(dto.getMail());
        dealer.setType(dto.getType());

        return dealerRepository.save(dealer);
    }

    public Dealer updateDealer(DealerDTO dto, long id) {
        Dealer excistingDealer = dealerRepository.findById(id);
        if (excistingDealer == null) {
            throw new EntityNotFoundException("Dealer with id" + id + "not found");
        }
        excistingDealer.setCity(dto.getCity());
        excistingDealer.setName(dto.getName());
        excistingDealer.setStreet(dto.getStreet());
        excistingDealer.setZipCode(dto.getZipCode());
        excistingDealer.setPhone(dto.getPhone());
        excistingDealer.setMail(dto.getMail());
        excistingDealer.setType(dto.getType());

        return dealerRepository.save(excistingDealer);
    }
    public void deleteDealer(long id) {
        Dealer excistingDealer = dealerRepository.findById(id);
        if (excistingDealer == null) {
            throw new EntityNotFoundException("Dealer with id" + id + "not found");
        }
        dealerRepository.delete(excistingDealer);
    }



}
