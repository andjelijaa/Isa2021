package com.example.backend.models;


import lombok.*;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vlasnik")
    private List<Vikendica> vikendice;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vlasnik")
    private List<Cas> casovi;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vlasnik")
    private List<Brod> brodovi;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klijent")
    private List<Rezervacija> rezervacije;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loyality")
    private List<Loyalty> loyalties;

    public List<Loyalty> getLoyalties() {
        return loyalties;
    }

    public void setLoyalties(List<Loyalty> loyalties) {
        this.loyalties = loyalties;
    }

    public User(Long id, String username, String password, String address, String ime, String prezime, String grad, String drzava, String phone, Role role, String activation, List<Vikendica> vikendice, List<Cas> casovi, List<Brod> brodovi, List<Rezervacija> rezervacije, List<Loyalty> loyalties) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.ime = ime;
        this.prezime = prezime;
        this.grad = grad;
        this.drzava = drzava;
        this.phone = phone;
        this.role = role;
        this.activation = activation;
        this.vikendice = vikendice;
        this.casovi = casovi;
        this.brodovi = brodovi;
        this.rezervacije = rezervacije;
        this.loyalties = loyalties;
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

    public List<Vikendica> getVikendice() {
        return vikendice;
    }

    public void setVikendice(List<Vikendica> vikendice) {
        this.vikendice = vikendice;
    }

    public List<Cas> getCasovi() {
        return casovi;
    }

    public void setCasovi(List<Cas> casovi) {
        this.casovi = casovi;
    }

    public List<Brod> getBrodovi() {
        return brodovi;
    }

    public void setBrodovi(List<Brod> brodovi) {
        this.brodovi = brodovi;
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

}
