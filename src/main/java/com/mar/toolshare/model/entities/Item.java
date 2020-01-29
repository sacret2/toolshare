package com.mar.toolshare.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemId;

    @NotNull
    @Size(min=1, max=300)
    private String name;

    @NotNull
    private int qr;

    @Column(columnDefinition = "varchar(4000)")
    private String description;

    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental currentRental;

    @OneToMany (mappedBy = "item")
    @JsonIgnore
    List<Rental> rentals;

    public Item(){
    }

    public Item(@NotNull @Size(min = 1, max = 300) String name, @NotNull int qr, String description) {
        this.name = name;
        this.qr = qr;
        this.description = description;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQr() {
        return qr;
    }

    public void setQr(int qr) {
        this.qr = qr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
