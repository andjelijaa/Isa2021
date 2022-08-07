package com.example.backend.controllers;

import com.example.backend.models.Brod;
import com.example.backend.models.Cas;
import com.example.backend.models.Vikendica;
import com.example.backend.models.request.AkcijaRequestDTO;
import com.example.backend.services.AkcijaService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/akcija")
public class AkcijaController {

    private final AkcijaService akcijaService;

    public AkcijaController(AkcijaService akcijaService) {
        this.akcijaService = akcijaService;
    }

    @PostMapping("/brod/{brodId}")
    public Brod addAkcijaToBrod(@RequestBody AkcijaRequestDTO akcijaRequestDTO,
                                @PathVariable(name = "brodId") Long brodId) throws Exception {
        return akcijaService.addAkcijaToBrod(brodId, akcijaRequestDTO);
    }

    @PostMapping("/cas/{casId}")
    public Cas addAkcijaToCas(@RequestBody AkcijaRequestDTO akcijaRequestDTO,
                              @PathVariable(name = "casId") Long casId) throws Exception {
        return akcijaService.addAkcijaToCas(casId, akcijaRequestDTO);
    }

    @PostMapping("/vikendica/{vikendicaId}")
    public Vikendica addAkcijaToVikendica(@RequestBody AkcijaRequestDTO akcijaRequestDTO,
                                          @PathVariable(name = "vikendicaId") Long vikendicaId) throws Exception {
        return akcijaService.addAkcijaToVikendica(vikendicaId, akcijaRequestDTO);
    }
}
