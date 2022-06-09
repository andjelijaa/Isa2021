package com.example.backend.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vikendica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    private int brojSoba;
    private int brojKreveta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vlasnik_id")
    private User vlasnik;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vikendica")
    private List<Rezervacija> rezervacije;
}
