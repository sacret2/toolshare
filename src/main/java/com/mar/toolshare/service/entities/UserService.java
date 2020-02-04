package com.mar.toolshare.service.entities;

import com.mar.toolshare.databases.dto.IUserData;
import com.mar.toolshare.model.entities.UserAccount;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<IUserData> findManagers();

    void deleteById(long userId);

    UserAccount save(UserAccount userAccount);

    UserAccount findByUserName(String username);
}
