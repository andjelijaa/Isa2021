package com.example.backend.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Rezervacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String datumPocetka;
    private String vremePocetka;
    private int maxBrojOsoba;
    private String dodatneUsluge;
    private int cena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klijent_id")
    private User klijent;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brod_id")
    private Brod brod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vikendica_id")
    private Vikendica vikendica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cas_id")
    private Cas cas;


}