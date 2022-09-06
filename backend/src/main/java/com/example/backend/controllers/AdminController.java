package com.example.backend.controllers;

import com.example.backend.models.User;
import com.example.backend.models.Zalba;
import com.example.backend.models.request.OdgovorNaZahtevDTO;
import com.example.backend.models.response.ZahteviZaBrisanjeAdminDto;
import com.example.backend.services.UserService;
import com.example.backend.services.ZahtevService;
import com.example.backend.services.ZalbaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController("/api/admin")
public class AdminController {

    private final ZalbaService zalbaService;
    private final ZahtevService zahtevService;
    private final UserService userService;

    public AdminController(ZalbaService zalbaService,
                           ZahtevService zahtevService,
                           UserService userService) {
        this.zalbaService = zalbaService;
        this.zahtevService=zahtevService;
        this.userService=userService;
    }

    @GetMapping("/zalbe/all")
    public List<Zalba> getSveTrenutneZalbe(Principal principal) throws Exception {
        return zalbaService.getAllZalbe(principal);
    }

    @PostMapping("/zalbe/{id}")
    public boolean odgovori(Principal principal,
                            @PathVariable(name = "id") Long id,
                            @RequestBody String odgovorNaZalbu) throws Exception {
        return zalbaService.odgovori(principal, id, odgovorNaZalbu);
    }

    @GetMapping("/get-all-zahteve-za-brisanje")
    public List<ZahteviZaBrisanjeAdminDto> getSveNeobradjeneZahteve(Principal principal) throws Exception {
        userService.isUserAdmin(principal);
        return zahtevService.getSveNepregledane();
    }



    @PostMapping("/odgovori-na-zahtev")
    public boolean odgovorNaZahtev(Principal principal,
                                   @RequestBody OdgovorNaZahtevDTO odgovorNaZahtevDTO) throws Exception {
        User admin = userService.isUserAdmin(principal);
        return zahtevService.odgovorNaZahtev(admin, odgovorNaZahtevDTO);
    }
}