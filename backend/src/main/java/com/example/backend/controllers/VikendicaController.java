package com.example.backend.controllers;

import com.example.backend.models.Vikendica;
import com.example.backend.models.mappers.VikendicaMapper;
import com.example.backend.models.response.GetVikendicaDTO;

import com.example.backend.models.response.VikendicaDTO;
import com.example.backend.services.VikendicaService;
import com.example.backend.services.ZalbaService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController("/api/vikendica")
public class VikendicaController {

    private final VikendicaService vikendicaService;
    private final ZalbaService zalbaService;

    public VikendicaController(VikendicaService vikendicaService, ZalbaService zalbaService) {
        this.vikendicaService = vikendicaService;
        this.zalbaService=zalbaService;
    }

    @GetMapping("/getAll")
    public List<VikendicaDTO> getAll(Principal principal,
                                     @RequestParam(name = "sort", defaultValue = "id") String sort,
                                     @RequestParam(name = "type", defaultValue = "2") int type) throws Exception {
        return VikendicaMapper.toDto(vikendicaService.getAllVikendice(principal, sort,type));

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
