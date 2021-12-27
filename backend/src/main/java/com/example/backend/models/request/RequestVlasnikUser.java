package com.example.backend.models.request;

public class RequestVlasnikUser {

    private String email;
    private String lozinka;
    private String lozinkaPonovljena;
    private String ime;
    private String prezime;
    private String adresa;
    private String grad;
    private String drzava;
    private String brojTelefona;
    private String tipRegistracije;
    private String obrazlozenjeRegistracije;

    public RequestVlasnikUser() {
    }

    public RequestVlasnikUser(String email, String lozinka, String lozinkaPonovljena, String ime, String prezime, String adresa, String grad, String drzava, String brojTelefona, String tipRegistracije, String obrazlozenjeRegistracije) {
        this.email = email;
        this.lozinka = lozinka;
        this.lozinkaPonovljena = lozinkaPonovljena;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.brojTelefona = brojTelefona;
        this.tipRegistracije = tipRegistracije;
        this.obrazlozenjeRegistracije = obrazlozenjeRegistracije;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getLozinkaPonovljena() {
        return lozinkaPonovljena;
    }

    public void setLozinkaPonovljena(String lozinkaPonovljena) {
        this.lozinkaPonovljena = lozinkaPonovljena;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getTipRegistracije() {
        return tipRegistracije;
    }

    public void setTipRegistracije(String tipRegistracije) {
        this.tipRegistracije = tipRegistracije;
    }

    public String getObrazlozenjeRegistracije() {
        return obrazlozenjeRegistracije;
    }

    public void setObrazlozenjeRegistracije(String obrazlozenjeRegistracije) {
        this.obrazlozenjeRegistracije = obrazlozenjeRegistracije;
    }

    @Override
    public String toString() {
        return "RequestVlasnikUser{" +
                "email='" + email + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", lozinkaPonovljena='" + lozinkaPonovljena + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", adresa='" + adresa + '\'' +
                ", grad='" + grad + '\'' +
                ", drzava='" + drzava + '\'' +
                ", brojTelefona='" + brojTelefona + '\'' +
                ", tipRegistracije='" + tipRegistracije + '\'' +
                ", obrazlozenjeRegistracije='" + obrazlozenjeRegistracije + '\'' +
                '}';
    }
}
