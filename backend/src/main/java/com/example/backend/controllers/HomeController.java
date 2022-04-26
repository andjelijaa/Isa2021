package com.example.backend.controllers;


import com.example.backend.models.Brod;
import com.example.backend.models.Instruktor;
import com.example.backend.models.Vikendica;
import com.example.backend.models.local.HomeModel;
import com.example.backend.models.response.BrodDto;
import com.example.backend.models.response.InstruktorDto;
import com.example.backend.models.response.VikendicaDto;
import com.example.backend.repository.BrodRepository;
import com.example.backend.repository.InstruktorRepository;
import com.example.backend.repository.VikendicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController("/")
public class HomeController {

    @Autowired
    BrodRepository brodRepository;
    @Autowired
    VikendicaRepository vikendicaRepository;
    @Autowired
    InstruktorRepository instruktorRepository;

    @GetMapping("/getAll")
    public HomeModel home(){
        List<Brod> brodovi = brodRepository.findAll();
        List<Instruktor> instruktori = instruktorRepository.findAll();
        List<Vikendica> vikendice = vikendicaRepository.findAll();
        HomeModel returnModel = new HomeModel(instruktori, brodovi, vikendice);
        return returnModel;
}

    @GetMapping("/getVikendice")
    public List<VikendicaDto> vikendice(){
        List<Vikendica> vikendice = vikendicaRepository.findAll();

        List<VikendicaDto> returnModel = vikendice
                .stream()
                .map(vikendica -> new VikendicaDto(vikendica))
                .collect(Collectors.toList());

        return returnModel;
    }

    @GetMapping("/getInstruktori")
    public List<InstruktorDto> instruktori(){
        List<Instruktor> instruktori = instruktorRepository.findAll();

        List<InstruktorDto> returnModel = instruktori
                .stream()
                .map(instruktor -> new InstruktorDto(instruktor))
                .collect(Collectors.toList());

        return returnModel;
    }

    @GetMapping("/getBrodovi")
    public List<BrodDto> brodovi(){
        List<Brod> brodovi = brodRepository.findAll();

        List<BrodDto> returnModel = brodovi
                .stream()
                .map(brod -> new BrodDto(brod))
                .collect(Collectors.toList());

        return returnModel;
    }
}