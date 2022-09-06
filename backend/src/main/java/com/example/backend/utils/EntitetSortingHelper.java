package com.example.backend.utils;

import com.example.backend.models.Brod;
import com.example.backend.models.Entitet;
import com.example.backend.repository.EntitetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntitetSortingHelper {
    private final String id = "id";
    private final String ocena = "ocena";
    private final String naziv = "naziv";
    private final String lokacija = "lokacija";
    private final EntitetRepository entitetRepository;

    public EntitetSortingHelper(EntitetRepository entitetRepository) {
        this.entitetRepository = entitetRepository;
    }


    public Optional<List<Entitet>> getSortedEntiteti(String sort, int type){
        switch (sort){
            case id:
                return entitetRepository.findAllByOrderByIdAsc();
            case ocena:
                return entitetRepository.findAllByOrderByOcenaAsc();
            case naziv:
                return entitetRepository.findAllByOrderByNaziv();
            case lokacija:
                return entitetRepository.findAllByOrderByAdresa();
            default:
                return null;
        }
    }
}