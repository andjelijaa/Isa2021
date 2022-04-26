package com.example.backend.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(	name = "vikendice" )
public class Vikendica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vikendicaId")
    private int vikendicaId;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "opis")
    private String opis;

    @Column(name = "prosecna_ocena")
    private float prosecna_ocena;

    @Column(name = "slike")
    @ElementCollection(targetClass=Integer.class)
    private List<String> slike;

    @Column(name = "broj_soba")
    private int broj_soba;

    @Column(name = "broj_kreveta")
    private int broj_kreveta;

    @Column(name = "pravila_ponasanja")
    private String pravila_ponasanja;


    @Column(name="cenovnik")
    private Cenovnik cenovnik;

    @ManyToOne
    @JoinColumn(name = "vikendicaId",insertable = false, updatable = false)
    private Vlasnik vlasnik;

    public Vlasnik getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(Vlasnik vlasnik) {
        this.vlasnik = vlasnik;
    }

         public List<String> getSlike() {
             return slike;
         }

         public void setSlike(List<String> slike) {
             this.slike = slike;
         }

    public int getBroj_soba() {
        return broj_soba;
    }

    public void setBroj_soba(int broj_soba) {
        this.broj_soba = broj_soba;
    }

    public int getBroj_kreveta() {
        return broj_kreveta;
    }

    public void setBroj_kreveta(int broj_kreveta) {
        this.broj_kreveta = broj_kreveta;
    }

    public String getPravila_ponasanja() {
        return pravila_ponasanja;
    }

    public void setPravila_ponasanja(String pravila_ponasanja) {
        this.pravila_ponasanja = pravila_ponasanja;
    }

    public Vikendica() {
    }

    public int getVikendicaId() {
        return vikendicaId;
    }

    public void setVikendicaId(int vikendicaId) {
        this.vikendicaId = vikendicaId;
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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public float getProsecna_ocena() {
        return prosecna_ocena;
    }

    public void setProsecna_ocena(float prosecna_ocena) {
        this.prosecna_ocena = prosecna_ocena;
    }


    public Cenovnik getCenovnik() {
        return cenovnik;
    }

   public void setCenovnik(Cenovnik cenovnik) {
        this.cenovnik = cenovnik;
    }
}
