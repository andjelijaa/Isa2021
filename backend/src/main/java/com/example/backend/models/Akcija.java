package com.example.backend.models;

import com.example.backend.models.request.AkcijaRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Akcija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date datumOd;
    private Date datumDo;
    private String dodatneUsluge;
    private boolean pocela;
    private int cena;

    @ManyToOne(fetch = FetchType.EAGER)
    private Entitet entitet;

    @OneToOne
    private Rezervacija rezervacija;

    public Akcija() {
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public String getDodatneUsluge() {
        return dodatneUsluge;
    }

    public void setDodatneUsluge(String dodatneUsluge) {
        this.dodatneUsluge = dodatneUsluge;
    }

    public boolean isPocela() {
        return pocela;
    }

    public void setPocela(boolean pocela) {
        this.pocela = pocela;
    }

    public Entitet getEntitet() {
        return entitet;
    }

    public void setEntitet(Entitet entitet) {
        this.entitet = entitet;
    }

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }
}