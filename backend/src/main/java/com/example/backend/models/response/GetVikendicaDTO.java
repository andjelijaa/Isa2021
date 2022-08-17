package com.example.backend.models.response;


import com.example.backend.models.Vikendica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class GetVikendicaDTO {
    private Vikendica vikendica;
    private boolean daLiJeTrenutniUserVlasnik;

    public Vikendica getVikendica() {
        return vikendica;
    }

    public void setVikendica(Vikendica vikendica) {
        this.vikendica = vikendica;
    }

    public GetVikendicaDTO(Vikendica vikendica, boolean daLiJeTrenutniUserVlasnik) {
        this.vikendica = vikendica;
        this.daLiJeTrenutniUserVlasnik = daLiJeTrenutniUserVlasnik;
    }
}