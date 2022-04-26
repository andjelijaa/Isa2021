package com.example.backend.models.response;

import com.example.backend.models.Brod;


public class BrodDto {
    private int brodId;
    private String naziv;
    private String adresa;

    private String opis;
    private float prosecna_ocena;
    private String slobodni_termini;
    private String cenovnik;

    public BrodDto(Brod dto) {
        this.brodId = dto.getBrodId();
        this.naziv = dto.getNaziv();
        this.adresa = dto.getAdresa();
        this.opis = dto.getOpis();
        this.prosecna_ocena = dto.getProsecna_ocena();
        this.slobodni_termini = dto.getSlobodni_termini();
        this.cenovnik = dto.getCenovnik();
    }

    public int getBrodId() {
        return brodId;
    }

    public void setBrodId(int brodId) {
        this.brodId = brodId;
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

    public String getSlobodni_termini() {
        return slobodni_termini;
    }

    public void setSlobodni_termini(String slobodni_termini) {
        this.slobodni_termini = slobodni_termini;
    }

    public String getCenovnik() {
        return cenovnik;
    }

    public void setCenovnik(String cenovnik) {
        this.cenovnik = cenovnik;
    }
}
