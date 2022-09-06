package com.example.backend.services;

import com.example.backend.models.User;
import com.example.backend.models.ZahtevZaBrisanje;
import com.example.backend.models.request.OdgovorNaZahtevDTO;
import com.example.backend.models.response.ZahteviZaBrisanjeAdminDto;
import com.example.backend.repository.ZahtevZaBrisanjeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZahtevService {
    private final ZahtevZaBrisanjeRepository repository;
    private final EmailService emailService;
    private final UserService userService;

    public ZahtevService(ZahtevZaBrisanjeRepository repository,
                         EmailService emailService,
                         UserService userService) {
        this.repository = repository;
        this.emailService = emailService;
        this.userService = userService;
    }


    public List<ZahteviZaBrisanjeAdminDto> getSveNepregledane() throws Exception {

        List<ZahtevZaBrisanje> neobradjeniZahtevi = repository.findAllByIzbrisanFalse()
                .orElseThrow(() -> new Exception("Nema ni jednog neobradjenog zahteva"));
        List<ZahteviZaBrisanjeAdminDto> zahteviDto = neobradjeniZahtevi
                .stream()
                .map(zahtev -> {
                    return new ZahteviZaBrisanjeAdminDto(
                            zahtev.getId(),
                            zahtev.getZahtev(),
                            zahtev.getKorisnik()
                    );
                })
                .collect(Collectors.toList());
        return zahteviDto;
    }

    public boolean odgovorNaZahtev(User admin,
                                   OdgovorNaZahtevDTO odgZahtev) throws Exception {
        ZahtevZaBrisanje zahtev = repository.findById(odgZahtev.getId())
                .orElseThrow(() -> new Exception("Zahtev not found"));
        zahtev.setAdmin(admin);
        zahtev.setOdgovor(odgZahtev.getOdgovor());
        zahtev.setIzbrisan(odgZahtev.isFlag());

        repository.save(zahtev);
        emailService.sendEmailForZahtevZaBrisanje(zahtev.getKorisnik().getUsername(),
                odgZahtev.getOdgovor()
        );
        if(odgZahtev.isFlag()){
            userService.removeUser(zahtev.getKorisnik().getId());
        }
        return odgZahtev.isFlag();

    }
}
