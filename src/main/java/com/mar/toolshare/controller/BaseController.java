package com.mar.toolshare.controller;

import com.mar.toolshare.auxiliary.ZXingHelper;
import com.mar.toolshare.databases.dao.UserAccountRepository;

import com.mar.toolshare.model.security.UserData;
import com.mar.toolshare.model.security.authentication.TsUserDetails;
import com.mar.toolshare.model.entities.UserAccount;
import com.mar.toolshare.service.entities.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

public abstract class BaseController {

    @Autowired
    UserService userService;

    protected boolean addLoggedInUserDataToModel(Model model){
        UserData userData = getLoggedInUserData();
        boolean loggedIn = userData != null;
        model.addAttribute("loggedIn", loggedIn);
        if(userData == null)
            return false;
        model.addAttribute("userData", userData);
        boolean hasUserRole = userData.getRoles().contains("ROLE_USER");
        boolean hasManagerRole = userData.getRoles().contains("ROLE_MANAGER");
        boolean hasAdminRole = userData.getRoles().contains("ROLE_ADMIN");
        model.addAttribute("hasUserRole", hasUserRole);
        model.addAttribute("hasManagerRole", hasManagerRole);
        model.addAttribute("hasAdminRole", hasAdminRole);

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
        return userService.findByUserName(loggedInUserDetails.getUsername());
    }

    protected UserData getLoggedInUserData(){
        UserAccount loggedInUser = getLoggedInUserAccount();
        if(loggedInUser == null)
            return null;
        return new UserData(loggedInUser.getUserId(),loggedInUser.getUserName(),loggedInUser.getFirstName(),
                loggedInUser.getLastName(),loggedInUser.getAddressLine1(),loggedInUser.getAddressLine2(),
                loggedInUser.getZipCode(), loggedInUser.getEmail(), loggedInUser.isEnabled(),loggedInUser.getRoles());

    }

    protected UserData convertUserAccountToUserData(UserAccount userAccount){
        if(userAccount == null)
            return null;
        return new UserData(userAccount.getUserId(),userAccount.getUserName(),userAccount.getFirstName(),
                userAccount.getLastName(),userAccount.getAddressLine1(),userAccount.getAddressLine2(),
                userAccount.getZipCode(), userAccount.getEmail(), userAccount.isEnabled(),userAccount.getRoles());
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
