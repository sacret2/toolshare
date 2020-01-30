package com.mar.toolshare.service.entities;

import com.mar.toolshare.databases.dao.UserAccountRepository;

import com.mar.toolshare.databases.dto.IUserData;
import com.mar.toolshare.model.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserAccountRepository userAccountRepo;

    public List<IUserData> findManagers(){
        return userAccountRepo.findAllUserDataManagers();
    }

    public void deleteById(long userId) {
        userAccountRepo.deleteById(userId);
    }

    public UserAccount save(UserAccount userAccount){
        return userAccountRepo.save(userAccount);
    }
}
