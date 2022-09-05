package com.example.backend.utils;

import com.example.backend.models.Brod;
import com.example.backend.repository.BrodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrodSortingHelper {
    private final String id = "id";
    private final String ocena = "ocena";
    private final String naziv = "naziv";
    private final String lokacija = "lokacija";
    private final BrodRepository brodRepository;

    public BrodSortingHelper(BrodRepository brodRepository) {
        this.brodRepository = brodRepository;
    }


    public List<Brod> getSortedBrodovi(String sort, String value){
        switch (sort){
            case id:
                return brodRepository.findAllOrderByOcenaAsc();
            case ocena:
                return brodRepository.findByOcenaOrderByOcenaAsc(Integer.parseInt(value));
            case naziv:
                return brodRepository.findByNazivOrderByOcenaAsc(value);
            case lokacija:
                return brodRepository.findByAdresaOrderByOcenaAsc(value);
            default:
                return brodRepository.findAll();
        }
    }
}