package com.example.backend.controllers;

import com.example.backend.models.Vikendica;
import com.example.backend.models.mappers.VikendicaMapper;
import com.example.backend.models.response.GetVikendicaDTO;

import com.example.backend.models.response.VikendicaDTO;
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
    public List<VikendicaDTO> getAll(Principal principal) throws Exception {
        return VikendicaMapper.toDto(vikendicaService.getAllVikendice(principal));
    }

    @GetMapping("/{vikendicaId}")
    public GetVikendicaDTO getVikendica(Principal principal,
                                        @PathVariable(name = "vikendicaId") Long vikendicaId) throws Exception {
        return vikendicaService.getVikendicaByVikendicaId(principal, vikendicaId);
    }

    @PostMapping("/createVikendica")
    public VikendicaDTO create(Principal principal,
                            @RequestBody Vikendica vikendica) throws Exception {
        return VikendicaMapper.INSTANCE.toDto(vikendicaService.createVikendica(principal, vikendica));
    }

    @PostMapping("/oceni/{vikendicaId}")
    public VikendicaDTO ocena(Principal principal,
                              @PathVariable(name = "vikendicaId") Long vikendicaId,
                              @RequestBody Long ocena) throws Exception {
        return VikendicaMapper.INSTANCE.toDto(vikendicaService.oceniVikendic(principal, vikendicaId, ocena));
    }
}
