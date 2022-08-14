package com.example.backend.controllers;

import com.example.backend.models.Vikendica;
import com.example.backend.models.response.GetVikendicaDTO;

import com.example.backend.services.VikendicaService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController("/api/vikendica")
public class VikendicaController {

    private final VikendicaService vikendicaService;

    public VikendicaController(VikendicaService vikendicaService) {
        this.vikendicaService = vikendicaService;
    }

    @GetMapping("/getAll")
    public List<Vikendica> getAll(Principal principal) throws Exception {
        return vikendicaService.getAllVikendice(principal);
    }

    @GetMapping("/{vikendicaId}")
    public GetVikendicaDTO getVikendica(Principal principal,
                                        @PathVariable(name = "vikendicaId") Long vikendicaId) throws Exception {
        return vikendicaService.getVikendicaByVikendicaId(principal, vikendicaId);
    }

    @PostMapping("/create")
    public Vikendica create(Principal principal,
                            @RequestBody Vikendica vikendica) throws Exception {
        return vikendicaService.createVikendica(principal, vikendica);
    }
}
