package com.example.backend.utils;


import com.example.backend.models.Cas;
import com.example.backend.repository.CasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasSortingHelper {
    private final String id = "id";
    private final String ocena = "ocena";
    private final String naziv = "naziv";
    private final String lokacija = "lokacija";
    private final CasRepository casRepository;

    public CasSortingHelper(CasRepository casRepository) {
        this.casRepository = casRepository;
    }


    public List<Cas> getSortedCasovi(String sort, String value){
        switch (sort){
            case id:
                return casRepository.findAllOrderByNazivAsc();
            case ocena:
                return casRepository.findByOcenaOrderByNazivAsc(Integer.parseInt(value));
            case naziv:
                return casRepository.findByNazivOrderByNazivAsc(value);
            case lokacija:
                return casRepository.findByAdresaOrderByNazivAsc(value);
            default:
                return casRepository.findAll();
        }
    }
}
