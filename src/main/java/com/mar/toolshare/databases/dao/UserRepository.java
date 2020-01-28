package com.mar.toolshare.databases.dao;

import com.mar.toolshare.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
