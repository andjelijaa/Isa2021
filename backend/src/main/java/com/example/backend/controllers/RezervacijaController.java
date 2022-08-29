package com.example.backend.controllers;

import com.example.backend.models.Brod;
import com.example.backend.models.Cas;
import com.example.backend.models.Rezervacija;
import com.example.backend.models.Vikendica;
import com.example.backend.repository.RezervacijaRepository;
import com.example.backend.services.EmailService;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController("/api/rezervacije")
public class RezervacijaController {

    private final RezervacijaRepository rezervacijaRepository;
    private final EmailService emailService;

    public RezervacijaController(RezervacijaRepository rezervacijaRepository, EmailService emailService) {
        this.rezervacijaRepository = rezervacijaRepository;
        this.emailService = emailService;
    }

    @GetMapping("/{id}/brod/{brodId}")
    public Brod getBrod(@PathVariable(name = "brodId")Long brodId,
                        @PathVariable(name = "id")Long id){
        Rezervacija rezervacija = rezervacijaRepository.findByIdAndBrodId(id, brodId);

        return rezervacija.getBrod();
    }

    @GetMapping("/{id}/cas/{casId}")
    public Cas getCas(@PathVariable(name = "casId")Long casId,
                      @PathVariable(name = "id")Long id){
        Rezervacija rezervacija = rezervacijaRepository.findByIdAndCasId(id, casId);

        return rezervacija.getCas();
    }


    @GetMapping("/{id}/vikendica/{vikendicaId}")
    public Vikendica getVikendica(@PathVariable(name = "vikendicaId")Long vikendicaId,
                                  @PathVariable(name = "id")Long id){
        Rezervacija rezervacija = rezervacijaRepository.findByIdAndVikendicaId(id, vikendicaId);

        return rezervacija.getVikendica();
    }

    @PostMapping("/{id}/brod/{brodId}")
    public Brod postBrod(@PathVariable(name = "brodId")Long brodId,
                         @PathVariable(name = "id")Long id,
                         @RequestBody Rezervacija rezervacija) throws MessagingException {
        rezervacijaRepository.save(rezervacija);
        emailService.sendRezervacijaEmail(rezervacija.getKlijent().getUsername());


        return rezervacija.getBrod();
    }

}