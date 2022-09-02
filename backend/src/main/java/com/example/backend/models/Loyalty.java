package com.example.backend.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Loyalty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pogodnosti;
    private int popust;
    private int bodovi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public Loyalty() {
    }

    public Loyalty(Long id, String pogodnosti, int popust, int bodovi) {
        this.id = id;
        this.pogodnosti = pogodnosti;
        this.popust = popust;
        this.bodovi = bodovi;
    }

    public Loyalty(Long id, String pogodnosti, int popust, int bodovi, User user) {
        this.id = id;
        this.pogodnosti = pogodnosti;
        this.popust = popust;
        this.bodovi = bodovi;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPogodnosti() {
        return pogodnosti;
    }

    public void setPogodnosti(String pogodnosti) {
        this.pogodnosti = pogodnosti;
    }

    public int getPopust() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    public int getBodovi() {
        return bodovi;
    }

    public void setBodovi(int bodovi) {
        this.bodovi = bodovi;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}