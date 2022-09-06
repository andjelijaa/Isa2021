package com.example.backend.models;

import javax.persistence.*;

@Entity
public class Zalba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String opis;
    private boolean isOdgovoreno;

    @OneToOne
    private Rezervacija rezervacija;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean isOdgovoreno() {
        return isOdgovoreno;
    }

    public void setOdgovoreno(boolean odgovoreno) {
        isOdgovoreno = odgovoreno;
    }

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }
}