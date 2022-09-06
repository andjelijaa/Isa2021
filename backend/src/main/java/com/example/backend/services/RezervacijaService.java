package com.example.backend.services;

import com.example.backend.models.*;
import com.example.backend.models.enums.LoyaltyPogodnost;
import com.example.backend.repository.BrodRepository;
import com.example.backend.repository.CasRepository;
import com.example.backend.repository.RezervacijaRepository;
import com.example.backend.repository.VikendicaRepository;
import com.example.backend.utils.RezervacijaSortingHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class RezervacijaService {

    private final RezervacijaRepository rezervacijaRepository;
    private final EmailService emailService;
    private final BrodRepository brodRepository;
    private final CasRepository casRepository;
    private final VikendicaRepository vikendicaRepository;
    private final RezervacijaSortingHelper rezervacijaSortingHelper;

    public RezervacijaService(RezervacijaRepository rezervacijaRepository,
                              EmailService emailService,
                              BrodRepository brodRepository,
                              CasRepository casRepository,
                              VikendicaRepository vikendicaRepository,
                              RezervacijaSortingHelper rezervacijaSortingHelper) {
        this.rezervacijaRepository = rezervacijaRepository;
        this.emailService = emailService;
        this.brodRepository = brodRepository;
        this.casRepository=casRepository;
        this.vikendicaRepository=vikendicaRepository;
        this.rezervacijaSortingHelper=rezervacijaSortingHelper;
    }

    public Brod getBrodById(Long id, Long brodId, String sort) {
       List<Rezervacija> rezervacija = rezervacijaSortingHelper.getRezervacijeSortBrodovi(id, brodId, sort);


        return rezervacija.get(0).getBrod();

    }

    public Brod createRezervacijuZaBrod(Long brodId, Rezervacija rezervacija) throws Exception {
        Brod brod = brodRepository.findById(brodId).orElseThrow(() -> new Exception("Brod not found"));
        User user = rezervacija.getKlijent();
       /* LoyaltyPogodnost pogodnost = user.getLoyalties().get(0).getPogodnosti();
        if(pogodnost == LoyaltyPogodnost.POPUST_20){
            rezervacija.setCena(rezervacija.getCena() * 20/100);
        }else if(pogodnost == LoyaltyPogodnost.POPUST_30){
            rezervacija.setCena(rezervacija.getCena() * 30/100);
        }else if(pogodnost == LoyaltyPogodnost.POPUST_50){
            rezervacija.setCena(rezervacija.getCena() * 50/100);
        } */
        Rezervacija rez = rezervacijaRepository.saveAndFlush(rezervacija);
        if(user.getPenali() >= 3){
            throw new Exception("Ne mozete rezervisati brod zbog penala");
        }
   //     List<Rezervacija> rezervacije = brod.getRezervacije();
   //     rezervacije.add(rez);
   //     brod.setRezervacije(rezervacije);
        brodRepository.save(brod);
        emailService.sendRezervacijaEmail(rezervacija.getKlijent().getUsername());


        return brod;
    }

    public Cas getCasById(Long id, Long casId, String sort) {
        List<Rezervacija> rezervacija = rezervacijaSortingHelper.getRezervacijeSortCasovi(id,casId,sort);

        return rezervacija.get(0).getCas();
    }

    public Cas createRezervacijuZaCas(Long casId, Rezervacija rezervacija) throws Exception {
        Cas cas = casRepository.findById(casId).orElseThrow(() -> new Exception("Cas not found"));
        User user = rezervacija.getKlijent();
     /*   LoyaltyPogodnost pogodnost = user.getLoyalties().get(0).getPogodnosti();
        if(pogodnost == LoyaltyPogodnost.POPUST_20){
            rezervacija.setCena(rezervacija.getCena() * 20/100);
        }else if(pogodnost == LoyaltyPogodnost.POPUST_30){
            rezervacija.setCena(rezervacija.getCena() * 30/100);
        }else if(pogodnost == LoyaltyPogodnost.POPUST_50){
            rezervacija.setCena(rezervacija.getCena() * 50/100);
        }*/
        Rezervacija rez = rezervacijaRepository.saveAndFlush(rezervacija);
        if(user.getPenali() >= 3){
            throw new Exception("Ne mozete rezervisati cas zbog penala");
        }
     //   List<Rezervacija> rezervacije = cas.getRezervacije();
     //   rezervacije.add(rez);
     //   cas.setRezervacije(rezervacije);
        casRepository.save(cas);
        emailService.sendRezervacijaEmail(rezervacija.getKlijent().getUsername());


        return cas;
    }

    public Vikendica getVikendicaById(Long id, Long vikendicaId,String sort) {
        List<Rezervacija> rezervacija= rezervacijaSortingHelper.getRezervacijeSortVikendica(id, vikendicaId, sort);

        return rezervacija.get(0).getVikendica();
    }

    public Vikendica createRezervacijuZaVikendicu(Long vikendicaId, Rezervacija rezervacija) throws Exception {
        Vikendica vikendica = vikendicaRepository.findById(vikendicaId)
                .orElseThrow(() -> new Exception("Vikendica not found"));
        User user = rezervacija.getKlijent();
       /* LoyaltyPogodnost pogodnost = user.getLoyalties().get(0).getPogodnosti();
        if(pogodnost == LoyaltyPogodnost.POPUST_20){
            rezervacija.setCena(rezervacija.getCena() * 20/100);
        }else if(pogodnost == LoyaltyPogodnost.POPUST_30){
            rezervacija.setCena(rezervacija.getCena() * 30/100);
        }else if(pogodnost == LoyaltyPogodnost.POPUST_50){
            rezervacija.setCena(rezervacija.getCena() * 50/100);
        }*/
        Rezervacija rez = rezervacijaRepository.saveAndFlush(rezervacija);
        if(user.getPenali() >= 3){
            throw new Exception("Ne mozete rezervisati vikendicu zbog penala");
        }
   //     List<Rezervacija> rezervacije = vikendica.getRezervacije();
   //     rezervacije.add(rez);
   //     vikendica.setRezervacije(rezervacije);
        vikendicaRepository.save(vikendica);
        emailService.sendRezervacijaEmail(rezervacija.getKlijent().getUsername());


        return vikendica;
    }

    public boolean isUserHaveRezervation(User user, Vikendica vikendica) {
        Rezervacija rezervacija = rezervacijaRepository.findByUserAndVikendica(user, vikendica);
        if(rezervacija != null){
            return true;
        }
        return false;
    }
}