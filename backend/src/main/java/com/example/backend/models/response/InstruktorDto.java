package com.example.backend.models.response;

import com.example.backend.models.Instruktor;

import javax.persistence.Column;

public class InstruktorDto {
    private int instruktorId;
    private String naziv;
    private String adresa;
    private String opis;
    private float prosecna_ocena;

    public InstruktorDto(Instruktor dto) {
        this.instruktorId = dto.getInstruktorId();
        this.naziv = dto.getNaziv();
        this.adresa = dto.getAdresa();
        this.opis = dto.getOpis();
        this.prosecna_ocena = dto.getProsecna_ocena();
    }

    public int getInstruktorId() {
        return instruktorId;
    }

    public void setInstruktorId(int instruktorId) {
        this.instruktorId = instruktorId;
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
}
