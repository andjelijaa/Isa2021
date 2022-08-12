package com.example.backend.models.response;

import com.example.backend.models.Akcija;
import com.example.backend.models.Rezervacija;
import com.example.backend.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrodDTO {
    private Long id;
    private String naziv;
    private String adresa;
    private String promoOpis;
    private String slike;
    private int maxBrojOsoba;
    private String slobodniTermini;
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
    private User vlasnik;
    private List<Rezervacija> rezervacije;
    private Akcija akcija;
}