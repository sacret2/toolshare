package com.mar.toolshare.databases.dto;

public interface IUserData {
    long getUserId();
    String getUserName();
    String getFirstName();
    String getLastName();
    String getEmail();
    String getRoles();
    boolean getEnabled();
}
