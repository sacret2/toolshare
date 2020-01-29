package com.mar.toolshare.databases.dao;

import com.mar.toolshare.model.security.UserData;
import com.mar.toolshare.model.entities.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {
    Optional<UserAccount> findByUserName(String userName);

    @Query(nativeQuery = true, value = "SELECT  user_id , username, email, roles, enabled FROM user_account WHERE user_id = ?1")
    Optional<UserData> getUserDataByUserId(long userId);

}