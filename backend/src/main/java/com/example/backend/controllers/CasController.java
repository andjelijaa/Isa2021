package com.example.backend.controllers;

import com.example.backend.models.Cas;

import com.example.backend.models.response.GetCasDTO;
import com.example.backend.services.CasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.security.Principal;
import java.util.Optional;

@RestController("/api/cas")
public class CasController {

    private final CasService casService;

    public CasController(CasService casService) {
        this.casService = casService;
    }

    @GetMapping("/getAllCas")
    public List<Cas> getAll(Principal principal) throws Exception {
        return casService.getAllCasovi(principal);
    }

    @GetMapping("/{casId}")
    public GetCasDTO getCas(Principal principal,
                            @PathVariable(name = "casId") Long casId) throws Exception {
        return casService.getCasByCasId(principal, casId);
    }
}
