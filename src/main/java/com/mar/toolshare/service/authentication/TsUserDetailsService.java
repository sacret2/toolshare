package com.mar.toolshare.service.authentication;

import com.mar.toolshare.databases.dto.IUserData;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface TsUserDetailsService extends UserDetailsService {
    Optional<IUserData> getUserDataByUserId(long userId);

    UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;
}
