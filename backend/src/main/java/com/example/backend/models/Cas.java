package com.example.backend.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cas{
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

    private String kratkaBiografijaInstruktora;

    @ManyToOne
    @JoinColumn(name = "vlasnik_id")
    private User vlasnik;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cas")
    private List<Rezervacija> rezervacije;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cas")
    private List<Zalba> zalbe;

    public List<Zalba> getZalbe() {
        return zalbe;
    }

    public void setZalbe(List<Zalba> zalbe) {
        this.zalbe = zalbe;
    }

    @ManyToOne
    private Akcija akcija;

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

    public String getKratkaBiografijaInstruktora() {
        return kratkaBiografijaInstruktora;
    }

    public void setKratkaBiografijaInstruktora(String kratkaBiografijaInstruktora) {
        this.kratkaBiografijaInstruktora = kratkaBiografijaInstruktora;
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

    public Cas(Long id, String naziv, String adresa, String promoOpis, String slike, int maxBrojOsoba, String slobodniTermini, String pravilaPonasanja, String opremaUzRezervaciju, String cenovnikInfo, String usloviOtkaza, String kratkaBiografijaInstruktora, User vlasnik, List<Rezervacija> rezervacije, List<Zalba> zalbe, Akcija akcija) {
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
        this.kratkaBiografijaInstruktora = kratkaBiografijaInstruktora;
        this.vlasnik = vlasnik;
        this.rezervacije = rezervacije;
        this.zalbe = zalbe;
        this.akcija = akcija;
    }
}