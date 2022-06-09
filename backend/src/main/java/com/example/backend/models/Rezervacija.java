package com.example.backend.models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Rezervacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String datumPocetka;
    private String vremePocetka;
    private int maxBrojOsoba;
    private String dodatneUsluge;
    private int cena;

    @ManyToOne
    @JoinColumn(name = "klijent_id")
    private User klijent;


    @ManyToOne
    @JoinColumn(name = "brod_id")
    private Brod brod;
    @ManyToOne
    @JoinColumn(name = "vikendica_id")
    private Vikendica vikendica;
    @ManyToOne
    @JoinColumn(name = "cas_id")
    private Cas cas;


}