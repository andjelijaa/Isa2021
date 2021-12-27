package com.example.backend.models.local;

import com.example.backend.models.Brod;
import com.example.backend.models.Instruktor;
import com.example.backend.models.Vikendica;

import java.util.ArrayList;
import java.util.List;

public class HomeModel {
    private List<Instruktor> instruktors = new ArrayList<>();
    private List<Brod> brods = new ArrayList<>();
    private List<Vikendica> vikendicas = new ArrayList<>();

    public HomeModel(List<Instruktor> instruktors, List<Brod> brods, List<Vikendica> vikendicas) {
        this.instruktors = instruktors;
        this.brods = brods;
        this.vikendicas = vikendicas;
    }

    public HomeModel() {
    }

    public List<Instruktor> getInstruktors() {
        return instruktors;
    }

    public void setInstruktors(List<Instruktor> instruktors) {
        this.instruktors = instruktors;
    }

    public List<Brod> getBrods() {
        return brods;
    }

    public void setBrods(List<Brod> brods) {
        this.brods = brods;
    }

    public List<Vikendica> getVikendicas() {
        return vikendicas;
    }

    public void setVikendicas(List<Vikendica> vikendicas) {
        this.vikendicas = vikendicas;
    }

    @Override
    public String toString() {
        return "HomeModel{" +
                "instruktors=" + instruktors +
                ", brods=" + brods +
                ", vikendicas=" + vikendicas +
                '}';
    }
}
