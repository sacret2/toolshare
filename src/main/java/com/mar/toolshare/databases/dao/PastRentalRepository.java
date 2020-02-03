package com.mar.toolshare.databases.dao;

import com.mar.toolshare.databases.dto.IUserData;
import com.mar.toolshare.model.entities.PastRental;
import com.mar.toolshare.model.entities.Rental;
import com.mar.toolshare.model.entities.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PastRentalRepository extends PagingAndSortingRepository<PastRental, Long> {
    List<PastRental> findAllByUserAccount(UserAccount userAccount);

    @Query(nativeQuery = true, value = "SELECT *"+
            " FROM rental pr where pr.dtype!='Rental' and item_id = ?1")
    List<PastRental> findAllByItem(Long itemId);

    @Query(nativeQuery = true, value = "SELECT *"+
            " FROM rental r WHERE  r.dtype!='Rental' AND r.user_id = ?1 ")
    List<PastRental> findByUser_UserId(Long userId);
}
