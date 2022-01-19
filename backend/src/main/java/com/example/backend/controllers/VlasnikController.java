package com.example.backend.controllers;

import com.example.backend.models.Vikendica;
import com.example.backend.models.Vlasnik;
import com.example.backend.repository.VikendicaRepository;
import com.example.backend.repository.VlasnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController("/vlasnik")
public class VlasnikController {

    @Autowired
    VlasnikRepository vlasnikRepository;
    @Autowired
    VikendicaRepository vikendicaRepository;


    @GetMapping("/pretraga")
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

    




}
