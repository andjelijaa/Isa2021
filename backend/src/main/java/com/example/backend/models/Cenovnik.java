package com.example.backend.models;



import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "cenovnik")
@AllArgsConstructor
public class Cenovnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cenovnikId")
    private int cenovnikId;

//    private Map<String, Integer> cene;
//
//    public Cenovnik(Map<String, Integer> cene) {
//        this.cene = cene;
//    }
//
//    public Cenovnik() {
//        this.cene = new HashMap<>();
//    }
//
//    public Map<String, Integer> getCene() {
//        return cene;
//    }
//
//    public void add(String ime, Integer cena){
//        this.cene.put(ime, cena);
//    }
//
//    public void setCene(Map<String, Integer> cene) {
//        this.cene = cene;
//    }
//
//    @Override
//    public String toString() {
//        return "Cenovnik{" +
//                "cene=" + cene +
//                '}';
//    }
}