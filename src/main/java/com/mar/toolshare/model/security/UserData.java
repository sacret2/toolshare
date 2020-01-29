package com.mar.toolshare.model.security;


public class UserData {
    private long userId;
    private String userName;
    private String email;
    private boolean enabled = true;
    private String roles = "ROLE_USER";

    public UserData(long userId, String userName, String email, String roles, boolean enabled) {
        this.userName = userName;
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
}
