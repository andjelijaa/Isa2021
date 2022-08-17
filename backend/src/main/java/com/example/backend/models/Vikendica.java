package com.example.backend.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vikendica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    private int brojSoba;
    private int brojKreveta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vlasnik_id")
    private User vlasnik;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vikendica")
    private List<Rezervacija> rezervacije;

    @ManyToOne
    private Akcija akcija;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getBrojSoba() {
        return brojSoba;
    }

    public void setBrojSoba(int brojSoba) {
        this.brojSoba = brojSoba;
    }

    public int getBrojKreveta() {
        return brojKreveta;
    }

    public void setBrojKreveta(int brojKreveta) {
        this.brojKreveta = brojKreveta;
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
