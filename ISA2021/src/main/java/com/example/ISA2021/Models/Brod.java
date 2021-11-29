package com.example.ISA2021.Models;
import javax.persistence.*;

@Entity
@Table(	name = "brodovi" )
public class Brod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brodId")
    private int brodId;
    @Column(name = "naziv")
    private String naziv;
    @Column(name = "adresa")
    private String adresa;

    @Column(name = "opis")
    private String opis;
    @Column(name = "prosecna_ocena")
    private float prosecna_ocena;
    @Column(name = "slobodni_termini")
    private String slobodni_termini;
    @Column(name = "cenovnik")
    private String cenovnik;

    public Brod() {
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
