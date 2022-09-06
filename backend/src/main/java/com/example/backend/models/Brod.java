package com.example.backend.models;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("1")
public class Brod extends  Entitet{

    private String tip;
    private int duzina;
    private String brojMotora;
    private String snagaMotora;
    private int maxSpreed;
    private String navigacionaOprema;


    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getDuzina() {
        return duzina;
    }

    public void setDuzina(int duzina) {
        this.duzina = duzina;
    }

    public String getBrojMotora() {
        return brojMotora;
    }

    public void setBrojMotora(String brojMotora) {
        this.brojMotora = brojMotora;
    }

    public String getSnagaMotora() {
        return snagaMotora;
    }

    public void setSnagaMotora(String snagaMotora) {
        this.snagaMotora = snagaMotora;
    }

    public int getMaxSpreed() {
        return maxSpreed;
    }

    public void setMaxSpreed(int maxSpreed) {
        this.maxSpreed = maxSpreed;
    }

    public String getNavigacionaOprema() {
        return navigacionaOprema;
    }

    public void setNavigacionaOprema(String navigacionaOprema) {
        this.navigacionaOprema = navigacionaOprema;
    }



}
