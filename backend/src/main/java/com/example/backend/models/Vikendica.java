package com.example.backend.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("2")
public class Vikendica extends Entitet{

    private int brojSoba;
    private int brojKreveta;

    public int getBrojSoba() {
        return brojSoba;
    }

    public void setBrojSoba(int brojSoba) {
        this.brojSoba = brojSoba;
    }

    public int getBrojKreveta() {
        return brojKreveta;
    }

    public void setBrojKreveta(int brojKreveta) {
        this.brojKreveta = brojKreveta;
    }

}
