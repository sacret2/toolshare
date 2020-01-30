package com.mar.toolshare.model.security;


import com.mar.toolshare.databases.dto.IUserData;

public class UserData implements IUserData {
    private long userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private boolean enabled = true;
    private String roles = "ROLE_USER";

    public UserData(long userId, String userName, String firstName, String lastName, String email, boolean enabled, String roles){
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enabled = enabled;
        this.roles = roles;
    }

    public long getUserId() {        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public boolean getEnabled() {
        return isEnabled();
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
