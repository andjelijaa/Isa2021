package com.example.backend.models;

import javax.persistence.*;

@Entity
public class ZahtevZaBrisanje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String zahtev;
    private String odgovor;
    private boolean izbrisan;

    @OneToOne(mappedBy = "zahtev")
    private User korisnik;

    @ManyToOne(fetch = FetchType.EAGER)
    private User admin;

    public ZahtevZaBrisanje() {
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZahtev() {
        return zahtev;
    }

    public void setZahtev(String zahtev) {
        this.zahtev = zahtev;
    }

    public User getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(User korisnik) {
        this.korisnik = korisnik;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public boolean isIzbrisan() {
        return izbrisan;
    }

    public void setIzbrisan(boolean izbrisan) {
        this.izbrisan = izbrisan;
    }
}