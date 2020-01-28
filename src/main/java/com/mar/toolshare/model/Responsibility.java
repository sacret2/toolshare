package com.mar.toolshare.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Responsibility {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long respId;

    @NotNull
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinColumn( name = "user_id")
    private User user;

    @NotNull
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinColumn( name = "item_id")
    private Item item;

    @NotNull
    private LocalDateTime start;

    private LocalDateTime end;

    public Responsibility() {

    }

    public Responsibility(@NotNull User user, @NotNull Item item, @NotNull LocalDateTime start, LocalDateTime end) {
        this.user = user;
        this.item = item;
        this.start = start;
        this.end = end;
    }

    public long getRespId() {
        return respId;
    }

    public void setRespId(long respId) {
        this.respId = respId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
