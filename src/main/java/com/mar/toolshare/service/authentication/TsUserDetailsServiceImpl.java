package com.mar.toolshare.service.authentication;

import com.mar.toolshare.databases.dao.UserAccountRepository;
import com.mar.toolshare.databases.dto.IUserData;
import com.mar.toolshare.model.security.authentication.TsUserDetails;
import com.mar.toolshare.model.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class TsUserDetailsServiceImpl implements TsUserDetailsService {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public Optional<IUserData> getUserDataByUserId(long userId){
        return userAccountRepository.getUserDataByUserId(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserAccount> user = userAccountRepository.findByUserName(userName);
        user.orElseThrow(()-> new UsernameNotFoundException("Not found " + userName));
        return user.map(TsUserDetails::new).get();
    }
}
