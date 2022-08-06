package com.example.backend.models;

import com.example.backend.models.request.AkcijaRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Akcija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date datumOd;
    private Date datumDo;
    private String tipAkcije;

    public Akcija(AkcijaRequestDTO akcijaRequestDTO) {
        this.id = akcijaRequestDTO.getId();
        this.datumOd = akcijaRequestDTO.getDatumOd();
        this.datumDo = akcijaRequestDTO.getDatumDo();
        this.tipAkcije = akcijaRequestDTO.getTipAkcije();
    }
}