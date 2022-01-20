package com.example.backend.controllers;

import com.example.backend.models.Rezervacije;
import com.example.backend.models.Vikendica;
import com.example.backend.models.Vlasnik;
import com.example.backend.repository.RezervacijeRepository;
import com.example.backend.repository.VikendicaRepository;
import com.example.backend.repository.VlasnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController("/vlasnik")
public class VlasnikController {

    @Autowired
    VlasnikRepository vlasnikRepository;
    @Autowired
    VikendicaRepository vikendicaRepository;


    @Autowired
    RezervacijeRepository rezervacijeRepository;

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

    @PostMapping("/dodaj")
    public Vikendica dodaj(@CookieValue(value = "userId", defaultValue = "") String vlasnikId,
                           @RequestBody Vikendica vikendica){
        if(!vlasnikId.equals("")){
            Optional<Vlasnik> vlasnik = vlasnikRepository.findById(Long.parseLong(vlasnikId));
            if(vlasnik.get() == null){
                return null;
            }else{
                vikendica.setVlasnik(vlasnik.get());
                Vikendica newVikendica = vikendicaRepository.saveAndFlush(vikendica);
                return newVikendica;
            }
        }
        return null;
    }

    @PutMapping("/izmeni")
    public Vikendica izmeni(@CookieValue(value = "userId", defaultValue = "") String vlasnikId,
                            @RequestBody Vikendica vikendica){
        if(!vlasnikId.equals("")){
            Optional<Vlasnik> vlasnik = vlasnikRepository.findById(Long.parseLong(vlasnikId));
            if(vlasnik.get() == null){
                return null;
            }else{
                Vikendica newVikendica = vikendicaRepository.saveAndFlush(vikendica);
                return newVikendica;
            }
        }
        return null;
    }

    @DeleteMapping("/izbrisi")
    public void izbrisi(@CookieValue(value = "userId", defaultValue = "") String vlasnikId,
                        @RequestBody Vikendica vikendica){
        if(!vlasnikId.equals("")){
            Optional<Vlasnik> vlasnik = vlasnikRepository.findById(Long.parseLong(vlasnikId));
            if(vlasnik.get() != null){
                vikendicaRepository.delete(vikendica);
            }
        }
    }
    @PostMapping("/definisi")
    public void definisi(@CookieValue(value = "userId", defaultValue = "") String vlasnikId,
                         @RequestBody Rezervacije rezervacije){
        if(!vlasnikId.equals("")){
            Optional<Vlasnik> vlasnik = vlasnikRepository.findById(Long.parseLong(vlasnikId));
            if(vlasnik.get() != null){
                rezervacijeRepository.save(rezervacije);
            }
        }
    }



}
