package com.mar.toolshare.databases.dto;

public interface IUserData {
    long getUserId();
    String getUserName();
    String getFirstName();
    String getLastName();
    String getAddressLine1();
    String getAddressLine2();
    String getZipCode();
    String getEmail();
    String getRoles();
    boolean getEnabled();
}
