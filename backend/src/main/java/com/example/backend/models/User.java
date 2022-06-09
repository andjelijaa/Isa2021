package com.example.backend.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vlasnik")
    private List<Vikendica> vikendice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vlasnik")
    private List<Cas> casovi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vlasnik")
    private List<Brod> brodovi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klijent")
    private List<Rezervacija> rezervacije;

}
