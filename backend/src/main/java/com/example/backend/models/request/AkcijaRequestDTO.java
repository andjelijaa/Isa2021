package com.example.backend.models.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
public class AkcijaRequestDTO {
    private Long id;
    private Date datumOd;
    private Date datumDo;
    private String tipAkcije;

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