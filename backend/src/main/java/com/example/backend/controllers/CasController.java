package com.example.backend.controllers;

import com.example.backend.models.Cas;

import com.example.backend.models.mappers.CasMapper;
import com.example.backend.models.response.CasDTO;
import com.example.backend.models.response.GetCasDTO;
import com.example.backend.services.CasService;

import java.util.List;
import java.security.Principal;
import java.util.Optional;

import com.example.backend.services.ZalbaService;
import org.springframework.web.bind.annotation.*;

@RestController("/api/cas")
public class CasController {

    private final CasService casService;
    private final ZalbaService zalbaService;


    public CasController(CasService casService, ZalbaService zalbaService) {
        this.casService = casService;
        this.zalbaService=zalbaService;
    }

    @GetMapping("/getAllCas")
    public List<CasDTO> getAll(Principal principal,@RequestParam(name = "sort", defaultValue = "id") String sort,
                               @RequestParam(name = "value") String value) throws Exception {
        return CasMapper.toDto(casService.getAllCasovi(principal, sort, value));
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

    @PostMapping("/zalba/{casId}")
    public boolean createZalbaZaCas(Principal principal,
                                    @PathVariable(name = "casId") Long casId,
                                    @RequestBody String zalbaOpis) throws Exception {
        return zalbaService.createZalbaZaCas(principal, casId, zalbaOpis);
    }
}
