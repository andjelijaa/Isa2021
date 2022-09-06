package com.example.backend.models.response;

import com.example.backend.models.Akcija;
import com.example.backend.models.Rezervacija;
import com.example.backend.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
public class BrodDTO {
    private Long id;
    private String naziv;
    private String adresa;
    private String promoOpis;
    private List<String> slike;
    private int maxBrojOsoba;
    private String slobodniTermini;
    private String pravilaPonasanja;
    private String opremaUzRezervaciju;
    private String cenovnikInfo;
    private String usloviOtkaza;
    private String tip;
    private int duzina;
    private String brojMotora;
    private String snagaMotora;
    private int maxSpreed;
    private List<String> navigacionaOprema;
    private User vlasnik;
  //  private List<Rezervacija> rezervacije;
  //  private Akcija akcija;

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

    public List<String> getSlike() {
        return slike;
    }

    public void setSlike(List<String> slike) {
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

    public String getBrojMotora() {
        return brojMotora;
    }

    public void setBrojMotora(String brojMotora) {
        this.brojMotora = brojMotora;
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

    public List<String> getNavigacionaOprema() {
        return navigacionaOprema;
    }

    public void setNavigacionaOprema(List<String> navigacionaOprema) {
        this.navigacionaOprema = navigacionaOprema;
    }

    public User getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(User vlasnik) {
        this.vlasnik = vlasnik;
    }

  /*  public List<Rezervacija> getRezervacije() {
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
*/
}