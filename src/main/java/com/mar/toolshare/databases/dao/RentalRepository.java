package com.mar.toolshare.databases.dao;

import com.mar.toolshare.model.entities.PastRental;
import com.mar.toolshare.model.entities.UserAccount;
import com.mar.toolshare.model.entities.Rental;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RentalRepository extends PagingAndSortingRepository<Rental, Long> {
    List<Rental> findAllByUserAccount(UserAccount userAccount);

    @Query(nativeQuery = true, value = "SELECT *"+
            " FROM rental r WHERE  r.dtype!='PastRental' AND r.item_id = ?1 ")
    Rental findByItem_ItemId(Long itemId);

    @Query(nativeQuery = true, value = "SELECT *"+
            " FROM rental r WHERE  r.dtype!='PastRental' AND r.user_id = ?1 ")
    List<Rental> findByUser_UserId(Long userId);
}
