package com.example.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(	name = "instruktori" )
public class Instruktor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "instruktorId")
        private int instruktorId;
        @Column(name = "naziv")
        private String naziv;
        @Column(name = "adresa")
        private String adresa;

        @Column(name = "opis")
        private String opis;
        @Column(name = "prosecna_ocena")
        private float prosecna_ocena;


}
