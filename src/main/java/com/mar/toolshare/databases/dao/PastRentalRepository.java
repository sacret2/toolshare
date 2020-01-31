package com.mar.toolshare.databases.dao;

import com.mar.toolshare.model.entities.PastRental;
import com.mar.toolshare.model.entities.UserAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PastRentalRepository extends PagingAndSortingRepository<PastRental, Long> {
    List<PastRental> findAllByUserAccount(UserAccount userAccount);
}
