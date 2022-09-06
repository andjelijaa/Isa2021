package com.example.backend.controllers;

import com.example.backend.models.Cas;
import com.example.backend.models.Rezervacija;
import com.example.backend.models.Vikendica;
import com.example.backend.repository.RezervacijaRepository;
import com.example.backend.services.EmailService;
import com.example.backend.services.RezervacijaService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController("/api/rezervacije")
public class RezervacijaController {

    private final RezervacijaRepository rezervacijaRepository;
    private final EmailService emailService;
    private final RezervacijaService rezervacijaService;

    public RezervacijaController(RezervacijaRepository rezervacijaRepository, EmailService emailService,RezervacijaService rezervacijaService) {
        this.rezervacijaRepository = rezervacijaRepository;
        this.emailService = emailService;
        this.rezervacijaService=rezervacijaService;
    }

    @GetMapping("/{rezervacijaID}/entitet/{entitetId}")
    public Optional<List<Rezervacija>> getSortedRezervacije(@PathVariable(name = "entitetId")Long entitetId,
                                                            @PathVariable(name = "rezervacijaID")Long rezervacijaID,
                                                            @RequestParam(name = "sort", defaultValue = "datum") String sort,
                                                            @RequestParam(name = "type") int type){
        return rezervacijaService.getEntitetsRezervaije(rezervacijaID, entitetId, sort, type);
    }



    @PostMapping("/vikendica/{vikendicaId}")
    public Vikendica postEntitet(Principal principal,
                                 @PathVariable(name = "vikendicaId") Long vikendicaId,
                                 @RequestBody Rezervacija rezervacija) throws Exception {
        return rezervacijaService.createRezervacijuZaVikendicu(principal, vikendicaId, rezervacija);
    }


    @PostMapping("/odkazi/{rezervacijaId}")
    public boolean odkaziRezervaciju(Principal principal,
                                     @PathVariable(name = "rezervacijaId") Long rezervacijaId) throws Exception {
        return rezervacijaService.odkazi(principal, rezervacijaId);
    }

}