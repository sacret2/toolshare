package com.mar.toolshare.service.entities;

import com.mar.toolshare.databases.dao.PastRentalRepository;
import com.mar.toolshare.model.entities.PastRental;
import com.mar.toolshare.model.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PastRentalService {

    @Autowired
    PastRentalRepository pastRentalRepo;

    public List<PastRental> findAllByUserAccount(UserAccount userAccount){
        return pastRentalRepo.findAllByUserAccount(userAccount);
    }

    public List<PastRental> findAllByItem(Long itemId){
        return pastRentalRepo.findAllByItem(itemId);
    }

    public  List<PastRental> findByUser_UserId(Long userId){
        return pastRentalRepo.findByUser_UserId(userId);
    }

    public void saveAll(List<PastRental> asList) {
        pastRentalRepo.saveAll(asList);
    }
}
