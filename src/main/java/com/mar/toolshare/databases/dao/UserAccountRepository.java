package com.mar.toolshare.databases.dao;

import com.mar.toolshare.databases.dto.IUserData;
import com.mar.toolshare.model.entities.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;
import java.util.Optional;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {
    Optional<UserAccount> findByUserName(String userName);

    @Query(nativeQuery = true, value = "SELECT user_Id as userId, username as userName, first_name as firstName,"+
            " last_name as lastName, address_line1 as addressLine1, address_line2 as addressLine2, " +
            "zip_code as zipCode, email, roles, enabled FROM user_account WHERE user_id = ?1")
    Optional<IUserData> getUserDataByUserId(long userId);

    @Query(nativeQuery = true, value = "SELECT user_Id as userId, username as userName, first_name as firstName,"+
            " last_name as lastName, address_line1 as addressLine1, address_line2 as addressLine2, " +
            "zip_code as zipCode, email, roles, enabled FROM user_account WHERE roles LIKE '%ROLE_MANAGER%'")
    List<IUserData> findAllUserDataManagers();

    @Override
    void deleteById(Long aLong);

    @Override
    <S extends UserAccount> S save(S s);
}