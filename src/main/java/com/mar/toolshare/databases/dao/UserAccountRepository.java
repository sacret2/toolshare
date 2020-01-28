package com.mar.toolshare.databases.dao;

import com.mar.toolshare.model.authentication.UserAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {
    Optional<UserAccount> findByUserName(String userName);
}