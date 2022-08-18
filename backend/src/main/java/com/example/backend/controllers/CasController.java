package com.example.backend.controllers;

import com.example.backend.models.Cas;

import com.example.backend.models.mappers.CasMapper;
import com.example.backend.models.response.CasDTO;
import com.example.backend.models.response.GetCasDTO;
import com.example.backend.services.CasService;

import java.util.List;
import java.security.Principal;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@RestController("/api/cas")
public class CasController {

    private final CasService casService;

    public CasController(CasService casService) {
        this.casService = casService;
    }

    @GetMapping("/getAllCas")
    public List<CasDTO> getAll(Principal principal) throws Exception {
        return CasMapper.toDto(casService.getAllCasovi(principal));
    }

    @GetMapping("/{casId}")
    public GetCasDTO getCas(Principal principal,
                            @PathVariable(name = "casId") Long casId) throws Exception {
        return casService.getCasByCasId(principal, casId);
    }

    @PostMapping("/createCas")
    public CasDTO createCas(Principal principal,
                          @RequestBody Cas cas) throws Exception {
        return CasMapper.INSTANCE.toDto(casService.createCas(principal, cas));
    }
}
