package com.example.backend.utils;

import com.example.backend.models.Rezervacija;
import com.example.backend.models.Vikendica;
import com.example.backend.repository.RezervacijaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RezervacijaSortingHelper {

    private final String datum = "datum";
    private final String cena = "cena";
    private final String trajanje = "trajanje";
    private final RezervacijaRepository rezervacijaRepository;

    public RezervacijaSortingHelper(RezervacijaRepository repository) {
        this.rezervacijaRepository = repository;
    }


    public Optional<List<Rezervacija>> getRezervacijeSortEntiteti(Long id, Long entitetId, String sort,int type){
        switch (sort){
            case datum:
                return rezervacijaRepository.findAllByOrderByDatumOdAsc();
            case cena:
                return rezervacijaRepository.findAllByOrderByCenaAsc();
            case trajanje:
                return rezervacijaRepository.findAllByOrderByTrajanjeAsc();
            default:
                return null;
        }
    }
}