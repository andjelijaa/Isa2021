package com.example.backend.controllers;

import com.example.backend.models.Brod;
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
}
