package com.example.backend.models;

import javax.persistence.*;

@Entity
@Table(	name = "instruktori" )
public class Instruktor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "instruktorId")
        private int instruktorId;
        @Column(name = "naziv")
        private String naziv;
        @Column(name = "adresa")
        private String adresa;

        @Column(name = "opis")
        private String opis;
        @Column(name = "prosecna_ocena")
        private float prosecna_ocena;

    public Instruktor() {
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
