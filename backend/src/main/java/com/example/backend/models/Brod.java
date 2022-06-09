package com.example.backend.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brod{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
    private String adresa;
    private String promoOpis;
    private String slike; //todo zameni sa listom
    private int maxBrojOsoba;
    private String slobodniTermini;//todo isto
    private String pravilaPonasanja;
    private String opremaUzRezervaciju;
    private String cenovnikInfo;
    private String usloviOtkaza;
    private String tip;
    private int duzina;
    private String brojMorora;
    private String snagaMotora;
    private int maxSpreed;
    private String navigacionaOprema;


    @ManyToOne
    @JoinColumn(name = "vlasnik_id")
    private User vlasnik;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brod")
    private List<Rezervacija> rezervacije;
}
