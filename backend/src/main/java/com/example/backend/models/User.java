package com.example.backend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String address;
    private String ime;
    private String prezime;
    private String grad;
    private String drzava;
    private String phone;

    private Role role;
    private String activation;

    private int zbirOcena;
    private int ukupnoOcena;

    @OneToMany
    @JoinColumn(name = "klijent_id")
    @JsonIgnore
    private List<Rezervacija> rezervacije;

    @OneToMany
    @JoinColumn(name = "vlasnik_id")
    @JsonIgnore
    private List<Entitet> entiteti;

    @OneToMany
    @JoinColumn(name = "zahtev_id")
    @JsonIgnore
    private List<ZahtevZaBrisanje> zahteviAdmin;

    @OneToOne
    private ZahtevZaBrisanje zahtevKorisnik;

  /*  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vlasnik")
    private List<Vikendica> vikendice;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vlasnik")
    private List<Cas> casovi;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vlasnik")
    private List<Brod> brodovi;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klijent")
    private List<Rezervacija> rezervacije;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Loyalty> loyalties;
*/
    private int penali;

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    public int getZbirOcena() {
        return zbirOcena;
    }

    public void setZbirOcena(int zbirOcena) {
        this.zbirOcena = zbirOcena;
    }

    public int getUkupnoOcena() {
        return ukupnoOcena;
    }

    public void setUkupnoOcena(int ukupnoOcena) {
        this.ukupnoOcena = ukupnoOcena;
    }

    public List<ZahtevZaBrisanje> getZahteviAdmin() {
        return zahteviAdmin;
    }

    public void setZahteviAdmin(List<ZahtevZaBrisanje> zahteviAdmin) {
        this.zahteviAdmin = zahteviAdmin;
    }

    public ZahtevZaBrisanje getZahtevKorisnik() {
        return zahtevKorisnik;
    }

    public void setZahtevKorisnik(ZahtevZaBrisanje zahtevKorisnik) {
        this.zahtevKorisnik = zahtevKorisnik;
    }

    public int getPenali() {
        return penali;
    }

    public void setPenali(int penali) {
        this.penali = penali;
    }

    public List<Entitet> getEntiteti() {
        return entiteti;
    }

    public void setEntiteti(List<Entitet> entiteti) {
        this.entiteti = entiteti;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    public void addOcena(int ocena) {
        int zbir = this.getZbirOcena() + ocena;
        this.setZbirOcena(zbir);
        this.setUkupnoOcena(this.getUkupnoOcena() + 1);
    }

    public float getProsek(){
        return this.getZbirOcena() / this.getUkupnoOcena();
    }

  /*  public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }
*/
}

