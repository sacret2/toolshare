package com.mar.toolshare.service.entities;

import com.mar.toolshare.model.entities.PastRental;
import com.mar.toolshare.model.entities.UserAccount;

import java.util.List;

public interface PastRentalService {
    List<PastRental> findAllByUserAccount(UserAccount userAccount);

    List<PastRental> findAllByItem(Long itemId);

    List<PastRental> findByUser_UserId(Long userId);

    void saveAll(List<PastRental> asList);
}
