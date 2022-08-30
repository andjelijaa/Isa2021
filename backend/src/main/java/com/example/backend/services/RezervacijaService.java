package com.example.backend.services;

import com.example.backend.models.Brod;
import com.example.backend.models.Cas;
import com.example.backend.models.Rezervacija;
import com.example.backend.repository.BrodRepository;
import com.example.backend.repository.CasRepository;
import com.example.backend.repository.RezervacijaRepository;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class RezervacijaService {

    private final RezervacijaRepository rezervacijaRepository;
    private final EmailService emailService;
    private final BrodRepository brodRepository;
    private final CasRepository casRepository;

    public RezervacijaService(RezervacijaRepository rezervacijaRepository,
                              EmailService emailService,
                              BrodRepository brodRepository,
                              CasRepository casRepository) {
        this.rezervacijaRepository = rezervacijaRepository;
        this.emailService = emailService;
        this.brodRepository = brodRepository;
        this.casRepository=casRepository;
    }

    public Brod getBrodById(Long id, Long brodId) {
        Rezervacija rezervacija = rezervacijaRepository.findByIdAndBrodId(id, brodId);


        return rezervacija.getBrod();

    }

    public Brod createRezervacijuZaBrod(Long brodId, Rezervacija rezervacija) throws Exception {
        Brod brod = brodRepository.findById(brodId).orElseThrow(() -> new Exception("Brod not found"));
        Rezervacija rez = rezervacijaRepository.saveAndFlush(rezervacija);
        List<Rezervacija> rezervacije = brod.getRezervacije();
        rezervacije.add(rez);
        brod.setRezervacije(rezervacije);
        brodRepository.save(brod);
        emailService.sendRezervacijaEmail(rezervacija.getKlijent().getUsername());


        return rezervacija.getBrod();
    }

    public Cas getCasById(Long id, Long casId) {
        Rezervacija rezervacija = rezervacijaRepository.findByIdAndCasId(id, casId);

        return rezervacija.getCas();
    }

    public Cas createRezervacijuZaCas(Long casId, Rezervacija rezervacija) throws Exception {
        Cas cas = casRepository.findById(casId).orElseThrow(() -> new Exception("Cas not found"));
        Rezervacija rez = rezervacijaRepository.saveAndFlush(rezervacija);
        List<Rezervacija> rezervacije = cas.getRezervacije();
        rezervacije.add(rez);
        cas.setRezervacije(rezervacije);
        casRepository.save(cas);
        emailService.sendRezervacijaEmail(rezervacija.getKlijent().getUsername());


        return rezervacija.getCas();
    }
}