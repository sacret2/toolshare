package com.mar.toolshare.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class PastRental extends Rental{

    public PastRental() {
    }

    public PastRental(@NotNull UserAccount userAccount, @NotNull Item item, @NotNull LocalDateTime start, LocalDateTime end) {
        this.userAccount = userAccount;
        this.item = item;
        this.start = start;
        this.end = end;
    }

    public String getFormattedEndDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return getEnd().format(formatter);
    }
}
