package com.mar.toolshare.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@SequenceGenerator(name="rental_seq", initialValue=1, allocationSize=1)
public class Rental {

    @Id
    @Column(name ="rental_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rental_seq")
    protected long rentalId;

    @NotNull
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinColumn( name = "user_id")
    protected UserAccount userAccount;

    @NotNull
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinColumn( name = "item_id")
    protected Item item;

    @NotNull
    protected LocalDateTime start;

    protected LocalDateTime end;


    public Rental() {

    }

    public Rental(@NotNull UserAccount userAccount, @NotNull Item item, @NotNull LocalDateTime start) {
        this.userAccount = userAccount;
        this.item = item;
        this.start = start;
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

    public String getFormattedEndDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return getEnd().format(formatter);
    }

    public String getFormattedStartDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return getStart().format(formatter);
    }

}
