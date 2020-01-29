package com.mar.toolshare.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class PastRental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long rentalId;

    @NotNull
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinColumn( name = "user_id")
    private UserAccount userAccount;

    @NotNull
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinColumn( name = "item_id")
    private Item item;

    @NotNull
    private LocalDateTime start;

    private LocalDateTime end;

    public PastRental() {

    }

    public PastRental(@NotNull UserAccount userAccount, @NotNull Item item, @NotNull LocalDateTime start, LocalDateTime end) {
        this.userAccount = userAccount;
        this.item = item;
        this.start = start;
        this.end = end;
    }

    public long getRentalId() {
        return rentalId;
    }

    public void setRentalId(long rentalId) {
        this.rentalId = rentalId;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
