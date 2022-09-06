package com.example.backend.models.response;

import com.example.backend.models.User;

public class ZahteviZaBrisanjeAdminDto {
    private long id;
    private String zahtev;
    private User korisnik;

    public ZahteviZaBrisanjeAdminDto() {
    }

    public ZahteviZaBrisanjeAdminDto(Long id, String zahtev, User korisnik) {
        this.id = id;
        this.zahtev = zahtev;
        this.korisnik = korisnik;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}