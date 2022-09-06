package com.example.backend.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Rezervacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date datumOd;
    private Date datumDo;
    private int trajanje;
    private int maxBrojOsoba;
    private String dodatneUsluge;
    private int cena;
    private boolean zauzeto;

    @ManyToOne(fetch = FetchType.EAGER)
    private User klijent;


    @ManyToOne(fetch = FetchType.EAGER)
    private Entitet entitet;

    public boolean isZauzeto() {
        return zauzeto;
    }

    public void setZauzeto(boolean zauzeto) {
        this.zauzeto = zauzeto;
    }

    @OneToOne
    private Zalba zalba;

    @OneToOne
    private Akcija akcija;

    public Rezervacija() {
    }

    public Akcija getAkcija() {
        return akcija;
    }

    public void setAkcija(Akcija akcija) {
        this.akcija = akcija;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public int getMaxBrojOsoba() {
        return maxBrojOsoba;
    }

    public void setMaxBrojOsoba(int maxBrojOsoba) {
        this.maxBrojOsoba = maxBrojOsoba;
    }

    public String getDodatneUsluge() {
        return dodatneUsluge;
    }

    public void setDodatneUsluge(String dodatneUsluge) {
        this.dodatneUsluge = dodatneUsluge;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public User getKlijent() {
        return klijent;
    }

    public void setKlijent(User klijent) {
        this.klijent = klijent;
    }

    public Entitet getEntitet() {
        return entitet;
    }

    public void setEntitet(Entitet entitet) {
        this.entitet = entitet;
    }

    public Zalba getZalba() {
        return zalba;
    }

    public void setZalba(Zalba zalba) {
        this.zalba = zalba;
    }
}