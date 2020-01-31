package com.mar.toolshare.databases.dao;

import com.mar.toolshare.model.entities.UserAccount;
import com.mar.toolshare.model.entities.Rental;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RentalRepository extends PagingAndSortingRepository<Rental, Long> {
    List<Rental> findAllByUserAccount(UserAccount userAccount);
}
