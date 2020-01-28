package com.mar.toolshare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mar.toolshare.model.authentication.UserAccount;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    UserAccount userAccount;

    @OneToMany (mappedBy = "user")
    @JsonIgnore
    List<Responsibility> responsibilities;

    public User() {
    }

    public User(UserAccount userAccount, List<Responsibility> responsibilities) {
        this.userAccount = userAccount;
        this.responsibilities = responsibilities;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public List<Responsibility> getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(List<Responsibility> responsibilities) {
        this.responsibilities = responsibilities;
    }
}
