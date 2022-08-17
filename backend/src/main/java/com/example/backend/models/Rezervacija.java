package com.example.backend.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Rezervacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String datumPocetka;
    private String vremePocetka;
    private int maxBrojOsoba;
    private String dodatneUsluge;
    private int cena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klijent_id")
    private User klijent;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brod_id")
    private Brod brod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vikendica_id")
    private Vikendica vikendica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cas_id")
    private Cas cas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(String datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public String getVremePocetka() {
        return vremePocetka;
    }

    public void setVremePocetka(String vremePocetka) {
        this.vremePocetka = vremePocetka;
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

    public Brod getBrod() {
        return brod;
    }

    public void setBrod(Brod brod) {
        this.brod = brod;
    }

    public Vikendica getVikendica() {
        return vikendica;
    }

    public void setVikendica(Vikendica vikendica) {
        this.vikendica = vikendica;
    }

    public Cas getCas() {
        return cas;
    }

    public void setCas(Cas cas) {
        this.cas = cas;
    }
}