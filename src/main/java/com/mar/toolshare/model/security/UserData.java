package com.mar.toolshare.model.security;


import com.mar.toolshare.databases.dto.IUserData;

public class UserData implements IUserData {
    private long userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String zipCode;
    private String email;
    private boolean enabled = true;
    private String roles = "ROLE_USER";

    public UserData(long userId, String userName, String firstName, String lastName, String addressLine1, String addressLine2, String zipCode, String email, boolean enabled, String roles) {
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.zipCode = zipCode;
        this.email = email;
        this.enabled = enabled;
        this.roles = roles;
    }

    @Override
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
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

    @Override
    public String getRoles() {
        return roles;
    }

    @Override
    public boolean getEnabled() {
        return isEnabled();
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
