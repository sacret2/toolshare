package com.mar.toolshare.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mar.toolshare.model.entities.PastRental;
import com.mar.toolshare.model.entities.Rental;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name="user_account_seq", initialValue=1, allocationSize=1)
public class UserAccount {

    @Id
    @Column(name ="user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_account_seq")
    private long userId;

    @Column(name = "username")
    private String userName;

    private String email;
    private String password;
    private boolean enabled = true;
    private String roles = "ROLE_USER";

    @OneToMany (mappedBy = "userAccount")
    @JsonIgnore
    List<Rental> rentals;

    @OneToMany (mappedBy = "userAccount")
    @JsonIgnore
    List<PastRental> pastRentals;

    public UserAccount(){

    }

    public long getUserId() {
        return userId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public List<PastRental> getPastRentals() {
        return pastRentals;
    }

    public void setPastRentals(List<PastRental> pastRentals) {
        this.pastRentals = pastRentals;
    }
}