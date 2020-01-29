package com.mar.toolshare.controller;

import com.mar.toolshare.databases.dao.UserAccountRepository;
import com.mar.toolshare.model.security.UserData;
import com.mar.toolshare.model.security.authentication.TsUserDetails;
import com.mar.toolshare.model.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

public abstract class BaseController {

    @Autowired
    UserAccountRepository userAccountRepo;

    protected boolean addLoggedInAndUserDataToModel(Model model){
        UserData userData = getLoggedInUserData();
        boolean loggedIn = userData != null;
        model.addAttribute("loggedIn", loggedIn);
        model.addAttribute("userData", userData);
        return loggedIn;
    }

    // ===== User data retrieving
    protected TsUserDetails getLoggedInUserDetails() {
        if(!isLoggedIn())
            return null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof String)
            return null;
        return (TsUserDetails) principal;
    }

    protected UserAccount getLoggedInUserAccount(){
        TsUserDetails loggedInUserDetails = getLoggedInUserDetails();
        if(loggedInUserDetails == null)
            return null;
        return userAccountRepo.findByUserName(loggedInUserDetails.getUsername()).orElse(null);
    }

    protected UserData getLoggedInUserData(){
        UserAccount loggedInUser = getLoggedInUserAccount();
        if(loggedInUser == null)
            return null;
        return new UserData(loggedInUser.getUserId(),loggedInUser.getUserName(),loggedInUser.getEmail(), loggedInUser.getRoles(),loggedInUser.isEnabled());

    }

    protected boolean isLoggedIn(Authentication au){
        return au != null && au.isAuthenticated() && !(au instanceof AnonymousAuthenticationToken);
    }

    protected boolean isLoggedIn(){
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        return isLoggedIn(au);
    }
    // ===== User data retrieving end
}
