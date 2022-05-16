
package com.example.backend.models.response;

import com.example.backend.models.Cenovnik;
import com.example.backend.models.Vikendica;
import com.example.backend.models.Vlasnik;

import java.util.List;

public class VikendicaDto {
    private int vikendicaId;
    private String naziv;
    private String adresa;
    private String opis;
    private float prosecna_ocena;
    private List<String> slike;
    private int broj_soba;
    private int broj_kreveta;
    private String pravila_ponasanja;
    private Cenovnik cenovnik;
    private Vlasnik vlasnik;

    public VikendicaDto(Vikendica dto) {
        this.vikendicaId = dto.getVikendicaId();
        this.naziv = dto.getNaziv();
        this.adresa = dto.getAdresa();
        this.opis = dto.getOpis();
        this.prosecna_ocena = dto.getProsecna_ocena();
        this.slike = dto.getSlike();
        this.broj_soba = dto.getBroj_soba();
        this.broj_kreveta = dto.getBroj_kreveta();
        this.pravila_ponasanja = dto.getPravila_ponasanja();
     //   this.cenovnik = dto.getCenovnik();
        this.vlasnik = dto.getVlasnik();
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

    public Cenovnik getCenovnik() {
        return cenovnik;
    }

    public void setCenovnik(Cenovnik cenovnik) {
        this.cenovnik = cenovnik;
    }

    public Vlasnik getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(Vlasnik vlasnik) {
        this.vlasnik = vlasnik;
    }
}
