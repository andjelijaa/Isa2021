package com.example.backend.controllers;

import com.example.backend.models.Brod;
import com.example.backend.models.Vikendica;
import com.example.backend.models.Vlasnik;
import com.example.backend.models.VlasnikBroda;
import com.example.backend.repository.BrodRepository;
import com.example.backend.repository.VikendicaRepository;
import com.example.backend.repository.VlasnikBrodaRepository;
import com.example.backend.repository.VlasnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/vlasnik-broda")
public class VlasnikBrodaController {

    @Autowired
    VlasnikBrodaRepository vlasnikBrodaRepository;
    @Autowired
    BrodRepository brodRepository;
    @Autowired
    VikendicaRepository vikendicaRepository;
    @Autowired
    VlasnikRepository vlasnikRepository;

    @GetMapping("/search")
    public List<Vikendica> getVikendice(@CookieValue(value = "userId", defaultValue = "") String vlasnikId){
        if(!vlasnikId.equals("")){
            Optional<Vlasnik> vlasnik = vlasnikRepository.findById(Long.parseLong(vlasnikId));

            if(vlasnik.get() == null){
                return null;
            }else{
                List<Vikendica> vikendice = vikendicaRepository.findByVlasnik(vlasnik.get());
                return vikendice;
            }
        }
        return null;
    }

    @PostMapping("/add")
    public List<Brod> dodaj(@CookieValue(value = "userId", defaultValue = "") String vlasnikId,
                            @RequestBody Brod brod){
        if(!vlasnikId.equals("")){
            Optional<VlasnikBroda> vlasnik = vlasnikBrodaRepository.findById(Long.parseLong(vlasnikId));
            if(vlasnik.get() == null){
                return null;
            }else{
                List<Brod> brodovi = brodRepository.findByVlasnikBroda(vlasnik.get());
                return brodovi;
            }
        }
        return null;
    }


}
