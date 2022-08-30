package com.example.backend.models;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
public class Brod{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
    private String adresa;
    private String promoOpis;
    private String slike; //todo zameni sa listom
    private int maxBrojOsoba;
    private String slobodniTermini;//todo isto
    private String pravilaPonasanja;
    private String opremaUzRezervaciju;
    private String cenovnikInfo;
    private String usloviOtkaza;
    private String tip;
    private int duzina;
    private String brojMorora;
    private String snagaMotora;
    private int maxSpreed;
    private String navigacionaOprema;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vlasnik_id")
    private User vlasnik;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "brod")
    private List<Rezervacija> rezervacije;

    @ManyToOne
    private Akcija akcija;

    public Brod(Long id, String naziv, String adresa, String promoOpis, String slike, int maxBrojOsoba, String slobodniTermini, String pravilaPonasanja, String opremaUzRezervaciju, String cenovnikInfo, String usloviOtkaza, String tip, int duzina, String brojMorora, String snagaMotora, int maxSpreed, String navigacionaOprema, User vlasnik, List<Rezervacija> rezervacije, Akcija akcija) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.promoOpis = promoOpis;
        this.slike = slike;
        this.maxBrojOsoba = maxBrojOsoba;
        this.slobodniTermini = slobodniTermini;
        this.pravilaPonasanja = pravilaPonasanja;
        this.opremaUzRezervaciju = opremaUzRezervaciju;
        this.cenovnikInfo = cenovnikInfo;
        this.usloviOtkaza = usloviOtkaza;
        this.tip = tip;
        this.duzina = duzina;
        this.brojMorora = brojMorora;
        this.snagaMotora = snagaMotora;
        this.maxSpreed = maxSpreed;
        this.navigacionaOprema = navigacionaOprema;
        this.vlasnik = vlasnik;
        this.rezervacije = rezervacije;
        this.akcija = akcija;
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

    public String getSlike() {
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

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getDuzina() {
        return duzina;
    }

    public void setDuzina(int duzina) {
        this.duzina = duzina;
    }

    public String getBrojMorora() {
        return brojMorora;
    }

    public void setBrojMorora(String brojMorora) {
        this.brojMorora = brojMorora;
    }

    public String getSnagaMotora() {
        return snagaMotora;
    }

    public void setSnagaMotora(String snagaMotora) {
        this.snagaMotora = snagaMotora;
    }

    public int getMaxSpreed() {
        return maxSpreed;
    }

    public void setMaxSpreed(int maxSpreed) {
        this.maxSpreed = maxSpreed;
    }

    public String getNavigacionaOprema() {
        return navigacionaOprema;
    }

    public void setNavigacionaOprema(String navigacionaOprema) {
        this.navigacionaOprema = navigacionaOprema;
    }

    public User getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(User vlasnik) {
        this.vlasnik = vlasnik;
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    public Akcija getAkcija() {
        return akcija;
    }

    public void setAkcija(Akcija akcija) {
        this.akcija = akcija;
    }


}
