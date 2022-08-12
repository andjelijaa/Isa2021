package com.example.backend.models.response;

import com.example.backend.models.Akcija;
import com.example.backend.models.Rezervacija;
import com.example.backend.models.User;

import java.util.List;

public class VikendicaDTO {
    private long id;
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
    private int brojSoba;
    private int brojKreveta;
    private User vlasnik;
    private List<Rezervacija> rezervacije;
    private Akcija akcija;
}