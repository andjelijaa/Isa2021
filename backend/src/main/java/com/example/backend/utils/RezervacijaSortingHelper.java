package com.example.backend.utils;

import com.example.backend.models.Rezervacija;
import com.example.backend.models.Vikendica;
import com.example.backend.repository.RezervacijaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RezervacijaSortingHelper {

    private final String datum = "datum";
    private final String cena = "cena";
    private final String trajanje = "trajanje";
    private final RezervacijaRepository rezervacijaRepository;

    public RezervacijaSortingHelper(RezervacijaRepository repository) {
        this.rezervacijaRepository = repository;
    }

    public List<Rezervacija> getRezervacijeSortVikendica(Long id, Long vikendicaId, String sort) {
        switch (sort) {
            case datum:
                return rezervacijaRepository.findByIdAndVikendicaIdOrderByDatumPocetkaAsc(id, vikendicaId);
            case cena:
                return rezervacijaRepository.findByIdAndVikendicaIdOrderByCenaAsc(id, vikendicaId);
            case trajanje:
                return rezervacijaRepository.findByIdAndVikendicaIdOrderByTrajanjeAsc(id, vikendicaId);
                default:
                return rezervacijaRepository.findAll();
    }
    }

    public List<Rezervacija> getRezervacijeSortBrodovi(Long id, Long brodId, String sort){
        switch (sort){
            case datum:
                return rezervacijaRepository.findByIdAndBrodIdOrderByDatumPocetkaAsc(id, brodId);
            case cena:
                return rezervacijaRepository.findByIdAndBrodIdOrderByCenaAsc(id, brodId);
            case trajanje:
                return rezervacijaRepository.findByIdAndBrodIdOrderByTrajanjeAsc(id, brodId);
            default:
                return rezervacijaRepository.findAll();
        }
    }

    public List<Rezervacija> getRezervacijeSortCasovi(Long id, Long casId, String sort){
        switch (sort){
            case datum:
                return rezervacijaRepository.findByIdAndCasIdOrderByDatumPocetkaAsc(id, casId);
            case cena:
                return rezervacijaRepository.findByIdAndCasIdOrderByCenaAsc(id, casId);
            case trajanje:
                return rezervacijaRepository.findByIdAndCasIdOrderByTrajanjeAsc(id, casId);
            default:
                return rezervacijaRepository.findAll();
        }
    }
}