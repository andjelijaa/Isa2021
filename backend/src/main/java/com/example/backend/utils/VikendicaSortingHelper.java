package com.example.backend.utils;

import com.example.backend.models.Vikendica;
import com.example.backend.repository.VikendicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VikendicaSortingHelper {
    private final String id = "id";
    private final String ocena = "ocena";
    private final String naziv = "naziv";
    private final String lokacija = "lokacija";
    private final VikendicaRepository vikendicaRepository;

    public VikendicaSortingHelper(VikendicaRepository vikendicaRepository) {
        this.vikendicaRepository = vikendicaRepository;
    }


    public List<Vikendica> getSortedVikendice(String sort, String value){
        switch (sort){
            case id:
                return vikendicaRepository.findAllOrderByNazivAsc();
            case ocena:
                return vikendicaRepository.findByOcenaOrderByNazivAsc(Integer.parseInt(value));
            case naziv:
                return vikendicaRepository.findByNazivOrderByNazivAsc(value);
            case lokacija:
                return vikendicaRepository.findByAdresaOrderByNazivAsc(value);
            default:
                return vikendicaRepository.findAll();
        }
    }
}
