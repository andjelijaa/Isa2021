package com.example.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",
        discriminatorType = DiscriminatorType.INTEGER)
public class Entitet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
    @ManyToOne(fetch = FetchType.EAGER)
    private User vlasnik;

    private String adresa;
    private String promoOpis;
    private String slike;
    private int maxBrojOsoba;
    private String slobodniTermini;//todo isto
    private String pravilaPonasanja;
    private String opremaUzRezervaciju;
    private String cenovnikInfo;
    private String usloviOtkaza;
    private int ocena;

    private int zbirOcena;
    private int ukupnoOcena;

    @OneToMany
    @JoinColumn(name = "entitet_id")
    @JsonIgnore
    private List<Rezervacija> rezervacije;

    @OneToMany
    @JoinColumn(name = "akcija_id")
    @JsonIgnore
    private List<Akcija> akcije;

    public List<Akcija> getAkcije() {
        return akcije;
    }

    public void setAkcije(List<Akcija> akcije) {
        this.akcije = akcije;
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    public int getUkupnoOcena() {
        return ukupnoOcena;
    }

    public void setUkupnoOcena(int ukupnoOcena) {
        this.ukupnoOcena = ukupnoOcena;
    }

    public int getZbirOcena() {
        return zbirOcena;
    }

    public void setZbirOcena(int zbirOcena) {
        this.zbirOcena = zbirOcena;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public User getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(User vlasnik) {
        this.vlasnik = vlasnik;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPromoOpis() {
        return promoOpis;
    }

    public void setPromoOpis(String promoOpis) {
        this.promoOpis = promoOpis;
    }

    public String  getSlike() {
        return slike;
    }

    public void setSlike(String slike) {
        this.slike = slike;
    }

    public int getMaxBrojOsoba() {
        return maxBrojOsoba;
    }

    public void setMaxBrojOsoba(int maxBrojOsoba) {
        this.maxBrojOsoba = maxBrojOsoba;
    }

    public String getSlobodniTermini() {
        return slobodniTermini;
    }

    public void setSlobodniTermini(String slobodniTermini) {
        this.slobodniTermini = slobodniTermini;
    }

    public String getPravilaPonasanja() {
        return pravilaPonasanja;
    }

    public void setPravilaPonasanja(String pravilaPonasanja) {
        this.pravilaPonasanja = pravilaPonasanja;
    }

    public String getOpremaUzRezervaciju() {
        return opremaUzRezervaciju;
    }

    public void setOpremaUzRezervaciju(String opremaUzRezervaciju) {
        this.opremaUzRezervaciju = opremaUzRezervaciju;
    }

    public String getCenovnikInfo() {
        return cenovnikInfo;
    }

    public void setCenovnikInfo(String cenovnikInfo) {
        this.cenovnikInfo = cenovnikInfo;
    }

    public String getUsloviOtkaza() {
        return usloviOtkaza;
    }

    public void setUsloviOtkaza(String usloviOtkaza) {
        this.usloviOtkaza = usloviOtkaza;
    }

    public void addOcena(int ocena) {
        int zbir = this.getZbirOcena() + ocena;
        this.setZbirOcena(zbir);
        this.setUkupnoOcena(this.getUkupnoOcena() + 1);
    }

    public float getProsek(){
        return this.getZbirOcena() / this.getUkupnoOcena();
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
}