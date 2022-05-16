package com.example.backend.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rezervacije" )
@Data
public class Rezervacije {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rezervacijaId")
    private int rezervacijaId;

    @Transient
    private Vikendica vikendica;


 //   @ManyToOne(cascade=CascadeType.ALL)
   // @JoinColumn(name = "id")
    private String user;
    private int vlasnikId;
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

 public String getUser() {
            return user;
    }

    public void setUser(String user) {
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
