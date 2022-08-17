package com.example.backend.models.response;

import com.example.backend.models.Cas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class GetCasDTO {
    private Cas cas;
    private boolean daLiJeTrenutniUserVlasnik;

    public Cas getCas() {
        return cas;
    }

    public void setCas(Cas cas) {
        this.cas = cas;
    }

    public boolean isDaLiJeTrenutniUserVlasnik() {
        return daLiJeTrenutniUserVlasnik;
    }

    public void setDaLiJeTrenutniUserVlasnik(boolean daLiJeTrenutniUserVlasnik) {
        this.daLiJeTrenutniUserVlasnik = daLiJeTrenutniUserVlasnik;
    }

    public GetCasDTO(Cas cas, boolean daLiJeTrenutniUserVlasnik) {
        this.cas = cas;
        this.daLiJeTrenutniUserVlasnik = daLiJeTrenutniUserVlasnik;
    }
}