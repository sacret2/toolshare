package com.mar.toolshare.service.entities.impl;

import com.mar.toolshare.databases.dao.PastRentalRepository;
import com.mar.toolshare.model.entities.PastRental;
import com.mar.toolshare.model.entities.UserAccount;
import com.mar.toolshare.service.entities.PastRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PastRentalServiceImpl implements PastRentalService {

    @Autowired
    PastRentalRepository pastRentalRepo;

    @Override
    public List<PastRental> findAllByUserAccount(UserAccount userAccount){
        return pastRentalRepo.findAllByUserAccount(userAccount);
    }

    @Override
    public List<PastRental> findAllByItem(Long itemId){
        return pastRentalRepo.findAllByItem(itemId);
    }

    @Override
    public  List<PastRental> findByUser_UserId(Long userId){
        return pastRentalRepo.findByUser_UserId(userId);
    }

    @Override
    public void saveAll(List<PastRental> asList) {
        pastRentalRepo.saveAll(asList);
    }
}
