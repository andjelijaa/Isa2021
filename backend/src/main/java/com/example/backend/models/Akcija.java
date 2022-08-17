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

    public String getTipAkcije() {
        return tipAkcije;
    }

    public void setTipAkcije(String tipAkcije) {
        this.tipAkcije = tipAkcije;
    }
}