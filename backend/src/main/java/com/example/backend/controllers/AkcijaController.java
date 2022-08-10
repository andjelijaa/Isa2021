package com.example.backend.controllers;

import com.example.backend.models.Brod;
import com.example.backend.models.Cas;
import com.example.backend.models.Vikendica;
import com.example.backend.models.request.AkcijaRequestDTO;
import com.example.backend.models.request.UpdateAkcijaDTO;
import com.example.backend.services.AkcijaService;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/brod/{brodId}")
    public Brod deleteAkcijuBrod(@PathVariable(name = "brodId") Long brodId) throws Exception {

        return akcijaService.deleteAkcijuBrod(brodId);
    }

    @DeleteMapping("/vikendica/{vikendicaId}")
    public Vikendica deleteAkcijaVikendica(@PathVariable(name = "brodId") Long vikendicaId) throws Exception {

        return akcijaService.deleteAkcijuVikendica(vikendicaId);
    }

    @PutMapping("/brod/{brodId}")
    public Brod updateAkcijaBrod(@PathVariable(name = "brodId") Long brodId,
                                 @RequestBody UpdateAkcijaDTO updateAkcijaDTO) throws Exception {
        return akcijaService.updateAkcijaBrod(brodId, updateAkcijaDTO);
    }

    @PutMapping("/vikendica/{vikendicaId}")
    public Vikendica updateAkcijaVikendica(@PathVariable(name = "vikendicaId") Long vikendicaId,
                                           @RequestBody UpdateAkcijaDTO updateAkcijaDTO) throws Exception {
        return akcijaService.updateAkcijaVikendica(vikendicaId, updateAkcijaDTO);
    }
}
