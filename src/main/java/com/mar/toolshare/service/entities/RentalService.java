package com.mar.toolshare.service.entities;

import com.mar.toolshare.model.entities.Rental;
import com.mar.toolshare.model.entities.UserAccount;

import java.util.List;

public interface RentalService {
    List<Rental> findAllByUserAccount(UserAccount userAccount);

    Rental findByItem_ItemId(Long itemId);

    List<Rental> findByUser_UserId(Long userId);

    void saveAll(List<Rental> asList);
}
