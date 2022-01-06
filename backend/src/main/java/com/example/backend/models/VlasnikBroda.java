package com.example.backend.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(	name = "vlasniciBroda" )
public class VlasnikBroda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vlasnikId")
    private int vlasnikId;
    private String ime;
    private String role;
    @OneToMany
    @JoinColumn(name = "brodId")
    private List<Brod> brodovi;

    public VlasnikBroda() {
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getVlasnikId() {
        return vlasnikId;
    }

    public void setVlasnikId(int vlasnikId) {
        this.vlasnikId = vlasnikId;
    }

    @Override
    public String toString() {
        return "Vlasnik{" +
                "vlasnikId=" + vlasnikId +
                ", ime='" + ime + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}