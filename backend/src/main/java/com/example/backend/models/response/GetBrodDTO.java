package com.example.backend.models.response;


import com.example.backend.models.Brod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class GetBrodDTO {
    private Brod brod;
    private boolean daLiJeTrenutniUserVlasnik;

    public GetBrodDTO(Brod brod, boolean daLiJeTrenutniUserVlasnik) {
        this.brod = brod;
        this.daLiJeTrenutniUserVlasnik = daLiJeTrenutniUserVlasnik;
    }

    public Brod getBrod() {
        return brod;
    }

    public void setBrod(Brod brod) {
        this.brod = brod;
    }

    public boolean isDaLiJeTrenutniUserVlasnik() {
        return daLiJeTrenutniUserVlasnik;
    }

    public void setDaLiJeTrenutniUserVlasnik(boolean daLiJeTrenutniUserVlasnik) {
        this.daLiJeTrenutniUserVlasnik = daLiJeTrenutniUserVlasnik;
    }
}