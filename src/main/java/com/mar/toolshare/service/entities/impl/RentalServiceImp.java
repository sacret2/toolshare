package com.mar.toolshare.service.entities.impl;

import com.mar.toolshare.databases.dao.RentalRepository;
import com.mar.toolshare.model.entities.Rental;
import com.mar.toolshare.model.entities.UserAccount;
import com.mar.toolshare.service.entities.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalServiceImp implements RentalService {
    @Autowired
    RentalRepository rentalRepo;

    @Override
    public List<Rental> findAllByUserAccount(UserAccount userAccount){
        return rentalRepo.findAllByUserAccount(userAccount);
    }

    @Override
    public Rental findByItem_ItemId(Long itemId){
        return rentalRepo.findByItem_ItemId(itemId);
    }

    @Override
    public List<Rental> findByUser_UserId(Long userId){
        return rentalRepo.findByUser_UserId(userId);
    }

    @Override
    public void saveAll(List<Rental> asList) {
        rentalRepo.saveAll(asList);
    }
}
