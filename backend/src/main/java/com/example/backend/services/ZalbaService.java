package com.example.backend.services;

import com.example.backend.models.*;
import com.example.backend.models.request.CreateZalbaDTO;
import com.example.backend.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import java.security.Principal;

@Service
public class ZalbaService {

    private final VikendicaRepository vikendicaRepository;
    private final CasRepository casRepository;
    private final BrodRepository brodRepository;
    private final UserService userService;
    private final ZalbaRepository zalbaRepository;
    private final EmailService emailService;
    private final RezervacijaRepository rezervacijaRepository;

    public ZalbaService(VikendicaRepository vikendicaRepository,
                        CasRepository casRepository,
                        BrodRepository brodRepository,
                        UserService userService,
                        ZalbaRepository zalbaRepository,
                        EmailService emailService,
                        RezervacijaRepository rezervacijaRepository) {
        this.vikendicaRepository = vikendicaRepository;
        this.casRepository = casRepository;
        this.brodRepository = brodRepository;
        this.userService = userService;
        this.zalbaRepository = zalbaRepository;
        this.emailService=emailService;
        this.rezervacijaRepository=rezervacijaRepository;
    }


    public boolean createZalbaZaEntitet(Principal principal,
                                     Long entitetId,
                                        CreateZalbaDTO zalba) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if(user == null){
            throw new Exception("Auth fail");
        }

        Rezervacija rezervacija = rezervacijaRepository.findByIdAndKlijentIdAndEntitetId(
                zalba.getRezervacijaId(),
                user.getId(),
                entitetId
        ).orElseThrow(() -> new Exception("Rezervacija not found"));

        Brod brod = (Brod) rezervacija.getEntitet();
        User vlasnik = brod.getVlasnik();
        vlasnik.addOcena(zalba.getOcena());
        brod.addOcena(zalba.getOcena());

        userService.save(vlasnik);
        brodRepository.save(brod);
        Zalba zalbaSave = new Zalba();
        zalbaSave.setOpis(zalba.getOpis());
        zalbaSave.setOdgovoreno(false);
        zalbaSave.setRezervacija(rezervacija);

        zalbaRepository.save(zalbaSave);
        return true;
    }



    public List<Zalba> getAllZalbe(Principal principal) throws Exception {
        User user = userService.isUserAdmin(principal);

        List<Zalba> zalbe = zalbaRepository.findAll();

        List<Zalba> filterZalbe = zalbe
                .stream()
                .filter((zalba) -> zalba.isOdgovoreno() == false)
                .collect(Collectors.toList());

        return filterZalbe;

    }

    public boolean odgovori(Principal principal, Long id, String odgovorNaZalbu) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if(user == null){
            throw new Exception("User not found");
        }
        if(user.getRole()!=Role.ROLE_ADMIN){
            throw new Exception("Authentificatio faild");
        }
        Zalba zalba = zalbaRepository.findById(id)
                .orElseThrow(() -> new Exception("zalba not found"));
        String vlasnik = zalba.getRezervacija().getEntitet().getVlasnik().getUsername();


        emailService.sendEmailForZalba(zalba.getRezervacija().getKlijent().getUsername(),
                vlasnik,
                zalba.getOpis(),
                odgovorNaZalbu);
        return true;
    }
}
