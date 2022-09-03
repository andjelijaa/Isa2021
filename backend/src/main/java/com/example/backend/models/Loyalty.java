package com.example.backend.models;


import com.example.backend.models.enums.LoyaltyPogodnost;

import javax.persistence.*;

@Entity
public class Loyalty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LoyaltyPogodnost pogodnost;
    private int popust;
    private int bodovi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public Loyalty() {
    }

    public Loyalty(Long id, LoyaltyPogodnost pogodnosti, int popust, int bodovi) {
        this.id = id;
        this.setPogodnost(pogodnosti);
        this.popust = popust;
        this.bodovi = bodovi;
    }

    public Loyalty(Long id, LoyaltyPogodnost pogodnosti, int popust, int bodovi, User user) {
        this.id = id;
        this.setPogodnost(pogodnosti);
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

    public LoyaltyPogodnost getPogodnosti() {
        return pogodnost;
    }

    public void setPogodnost(LoyaltyPogodnost pogodnost) {
        this.pogodnost = pogodnost;
        if(pogodnost == LoyaltyPogodnost.POPUST_20){
            this.popust = 20;
        }else if(pogodnost == LoyaltyPogodnost.POPUST_30){
            this.popust = 30;
        }else if(pogodnost == LoyaltyPogodnost.POPUST_50){
            this.popust = 50;
        }
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