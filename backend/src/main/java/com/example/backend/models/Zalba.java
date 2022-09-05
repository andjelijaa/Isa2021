package com.example.backend.models;

import javax.persistence.*;

@Entity
public class Zalba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String opis;
    @ManyToOne
    @JoinColumn(name="vikendica_id")
    private Vikendica vikendica;
    @ManyToOne
    @JoinColumn(name="cas_id")
    private Cas cas;
    @ManyToOne
    @JoinColumn(name="brod_id")
    private Brod brod;

    public Zalba() {
    }

    public Zalba(long id, String opis, Vikendica vikendica, Cas cas, Brod brod) {
        this.id = id;
        this.opis = opis;
        this.vikendica = vikendica;
        this.cas = cas;
        this.brod = brod;
    }

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

    public Vikendica getVikendica() {
        return vikendica;
    }

    public void setVikendica(Vikendica vikendica) {
        this.vikendica = vikendica;
    }

    public Cas getCas() {
        return cas;
    }

    public void setCas(Cas cas) {
        this.cas = cas;
    }

    public Brod getBrod() {
        return brod;
    }

    public void setBrod(Brod brod) {
        this.brod = brod;
    }
}