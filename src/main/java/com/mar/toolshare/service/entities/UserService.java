package com.mar.toolshare.service.entities;

import com.mar.toolshare.databases.dao.UserAccountRepository;

import com.mar.toolshare.databases.dto.IUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserAccountRepository userAccountRepo;

    public List<IUserData> findManagers(){
        System.out.println("SIZE====== " +userAccountRepo.findAllUserDataManagers().size());
        for (IUserData u: userAccountRepo.findAllUserDataManagers()
             ) {
            System.out.println("first name = " + u.getFirstName());
        }
        return userAccountRepo.findAllUserDataManagers();
    }

    public void deleteById(long userId) {
        userAccountRepo.deleteById(userId);
    }
}
