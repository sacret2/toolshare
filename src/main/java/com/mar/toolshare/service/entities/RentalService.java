package com.mar.toolshare.service.entities;

import com.mar.toolshare.databases.dao.RentalRepository;
import com.mar.toolshare.model.entities.Rental;
import com.mar.toolshare.model.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    @Autowired
    RentalRepository rentalRepo;

    public List<Rental> findAllByUserAccount(UserAccount userAccount){
        return rentalRepo.findAllByUserAccount(userAccount);
    }

    public Rental findByItem_ItemId(Long itemId){
        return rentalRepo.findByItem_ItemId(itemId);
    }

    public List<Rental> findByUser_UserId(Long userId){
        return rentalRepo.findByUser_UserId(userId);
    }

    public void saveAll(List<Rental> asList) {
        rentalRepo.saveAll(asList);
    }
}
