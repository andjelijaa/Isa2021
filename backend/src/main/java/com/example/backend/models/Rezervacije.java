package com.example.backend.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="rezervacija")
public class Rezervacije {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rezervacijaId")
    private int rezervacijaId;

    @ManyToOne
    private Vikendica vikendica;


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id")
    private User user;
    private Date start;
    private Date end;

    public Rezervacije() {
    }

    public int getRezervacijaId() {
        return rezervacijaId;
    }

    public void setRezervacijaId(int rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public Vikendica getVikendica() {
            return vikendica;
    }

    public void setVikendica(Vikendica vikendica) {
            this.vikendica = vikendica;
    }

    public User getUser() {
            return user;
    }

    public void setUser(User user) {
            this.user = user;
    }

    @Override
    public String toString() {
        return "Rezervacije{" +
                "rezervacijaId=" + rezervacijaId +
               ", vikendica=" + vikendica +
               ", user=" + user +
                '}';
    }

}
