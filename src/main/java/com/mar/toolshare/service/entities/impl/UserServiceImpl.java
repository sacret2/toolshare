package com.mar.toolshare.service.entities.impl;

import com.mar.toolshare.databases.dao.UserAccountRepository;

import com.mar.toolshare.databases.dto.IUserData;
import com.mar.toolshare.model.entities.UserAccount;
import com.mar.toolshare.service.entities.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserAccountRepository userAccountRepo;

    @Override
    public List<IUserData> findManagers(){
        return userAccountRepo.findAllUserDataManagers();
    }

    @Override
    public void deleteById(long userId) {
        userAccountRepo.deleteById(userId);
    }

    @Override
    public UserAccount save(UserAccount userAccount){
        return userAccountRepo.save(userAccount);
    }

    @Override
    public UserAccount findByUserName(String username) {
        return userAccountRepo.findByUserName(username).orElse(null);
    }
}
