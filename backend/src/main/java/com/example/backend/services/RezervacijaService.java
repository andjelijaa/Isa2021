package com.example.backend.services;

import com.example.backend.models.*;
import com.example.backend.models.enums.LoyaltyPogodnost;
import com.example.backend.repository.*;
import com.example.backend.utils.RezervacijaSortingHelper;
import org.hibernate.ResourceClosedException;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class RezervacijaService {

    private final RezervacijaRepository rezervacijaRepository;
    private final EmailService emailService;
    private final BrodRepository brodRepository;
    private final CasRepository casRepository;
    private final VikendicaRepository vikendicaRepository;
    private final RezervacijaSortingHelper rezervacijaSortingHelper;
    private final UserService userService;
    private final AdminService adminService;
    private final EntitetRepository entitetRepository;

    public RezervacijaService(RezervacijaRepository rezervacijaRepository,
                              EmailService emailService,
                              BrodRepository brodRepository,
                              CasRepository casRepository,
                              VikendicaRepository vikendicaRepository,
                              RezervacijaSortingHelper rezervacijaSortingHelper,
                              UserService userService, AdminService adminService, EntitetRepository entitetRepository) {
        this.rezervacijaRepository = rezervacijaRepository;
        this.emailService = emailService;
        this.brodRepository = brodRepository;
        this.casRepository=casRepository;
        this.vikendicaRepository=vikendicaRepository;
        this.rezervacijaSortingHelper=rezervacijaSortingHelper;
        this.userService = userService;
        this.adminService = adminService;
        this.entitetRepository=entitetRepository;
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

    public Optional<List<Rezervacija>> getEntitetsRezervaije(Long rezervacijaId, Long casId, String sort, int type) {
        Optional<List<Rezervacija>> rezervacije = rezervacijaSortingHelper.getRezervacijeSortEntiteti(
                rezervacijaId,
                casId,
                sort,
                type
        );

        return rezervacije;
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


    public Vikendica createRezervacijuZaVikendicu(Principal principal,
                                                  Long vikendicaId,
                                                  Rezervacija rezervacija) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if(user == null){
            throw new Exception("Auth fail");
        }
        Optional<Vikendica> vikendica = vikendicaRepository.findById(vikendicaId);
        if(vikendica.isPresent()){
            Optional<Rezervacija> rezervacijaOptim = rezervacijaRepository
                    .findByEntitetIdAndZauzetoTrue(vikendica.get().getId());
            if(rezervacijaOptim.isPresent()){
                throw new ResourceClosedException("Zauzeto u medjuvrremenu");
            }
        }

        rezervacija.setKlijent(user);
        rezervacija.setEntitet(vikendica.get());
        Rezervacija rez = rezervacijaRepository.saveAndFlush(rezervacija);
        if(user.getPenali() >= 3){
            throw new Exception("Nemozete rezervisati vikendicu zbog penala");
        }
        List<Rezervacija> rezervacije = vikendica.get().getRezervacije();
        rezervacije.add(rez);
        vikendica.get().setRezervacije(rezervacije);
        vikendicaRepository.save(vikendica.get());
        emailService.sendRezervacijaEmail(rezervacija.getKlijent().getUsername());
        return vikendica.get();
    }

    public boolean isUserHaveRezervation(User user, Vikendica vikendica) {
        Rezervacija rezervacija = rezervacijaRepository.findByKlijentIdAndEntitetId(user.getId(), vikendica.getId());
        if(rezervacija != null){
            return true;
        }
        return false;
    }

    public boolean odkazi(Principal principal, Long rezervacijaId) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if(user.getRole() == Role.ROLE_KORISNIK) {
            Date now = new Date();
            Rezervacija rezervacija = getRezervacijaForOtkaz(rezervacijaId, user.getId());
            Date dateRezervacije = rezervacija.getDatumOd();
            long nowMili = now.getTime();
            long rezervacijaMili = dateRezervacije.getTime();
            long razlika = rezervacijaMili - nowMili;
            long days = TimeUnit.MILLISECONDS.toDays(razlika);
            if (days <= 3) {
                adminService.notifyAdminDaOpetRezervise();
                rezervacija.setKlijent(null);
                rezervacija.setZauzeto(false);
                rezervacijaRepository.save(rezervacija);
                return true;
            }    }
            return false;


    }

    private Rezervacija getRezervacijaForOtkaz(Long rezervacijaId, Long id) throws Exception {
        return rezervacijaRepository.findByIdAndKlijentId(rezervacijaId, id)
                .orElseThrow(() -> new Exception("Rezervacija not found"));
    }
}