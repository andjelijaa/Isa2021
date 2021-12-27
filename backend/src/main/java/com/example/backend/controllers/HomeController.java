package com.example.backend.controllers;


import com.example.backend.models.Brod;
import com.example.backend.models.Instruktor;
import com.example.backend.models.Vikendica;
import com.example.backend.models.local.HomeModel;
import com.example.backend.repository.BrodRepository;
import com.example.backend.repository.InstruktorRepository;
import com.example.backend.repository.VikendicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class HomeController {

    @Autowired
    BrodRepository brodRepository;
    @Autowired
    VikendicaRepository vikendicaRepository;
    @Autowired
    InstruktorRepository instruktorRepository;

    @GetMapping("/")
    public String home(){
//        kupe se podatci iz baze o broovima vikendicama i instruktorima
        List<Brod> brodovi = brodRepository.findAll();
        List<Instruktor> instruktori = instruktorRepository.findAll();
        List<Vikendica> vikendice = vikendicaRepository.findAll();
        HomeModel returnModel = new HomeModel(instruktori, brodovi, vikendice);
        return "home";
    }
}
