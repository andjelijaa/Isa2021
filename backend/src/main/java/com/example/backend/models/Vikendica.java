package com.example.backend.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
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

    public List<Zalba> getZalbe() {
        return zalbe;
    }

    public void setZalbe(List<Zalba> zalbe) {
        this.zalbe = zalbe;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vikendica")
    private List<Zalba> zalbe;

    @ManyToOne
    private Akcija akcija;

    private float ocena;
    private int brojOcena;

    public int getBrojOcena() {
        return brojOcena;
    }

    public void setBrojOcena(int brojOcena) {
        this.brojOcena = brojOcena;
    }

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }

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

    public Vikendica(long id, String naziv, String adresa, String promoOpis, String slike, int maxBrojOsoba, String slobodniTermini, String pravilaPonasanja, String opremaUzRezervaciju, String cenovnikInfo, String usloviOtkaza, int brojSoba, int brojKreveta, User vlasnik, List<Rezervacija> rezervacije, Akcija akcija, float ocena, int brojOcena) {
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
        this.brojSoba = brojSoba;
        this.brojKreveta = brojKreveta;
        this.vlasnik = vlasnik;
        this.rezervacije = rezervacije;
        this.akcija = akcija;
        this.ocena = ocena;
        this.brojOcena = brojOcena;
    }


}
