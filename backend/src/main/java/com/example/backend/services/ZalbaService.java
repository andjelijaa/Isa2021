package com.example.backend.services;

import com.example.backend.models.*;
import com.example.backend.repository.BrodRepository;
import com.example.backend.repository.CasRepository;
import com.example.backend.repository.VikendicaRepository;
import com.example.backend.repository.ZalbaRepository;
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

    public ZalbaService(VikendicaRepository vikendicaRepository,
                        CasRepository casRepository,
                        BrodRepository brodRepository,
                        UserService userService,
                        ZalbaRepository zalbaRepository) {
        this.vikendicaRepository = vikendicaRepository;
        this.casRepository = casRepository;
        this.brodRepository = brodRepository;
        this.userService = userService;
        this.zalbaRepository = zalbaRepository;
    }


    public boolean createZalbaZaBrod(Principal principal,
                                     Long brodId,
                                     String zalbaOpis) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if(user == null){
            throw new Exception("User not found");
        }

        Brod brod = brodRepository.findById(brodId)
                .orElseThrow(() -> new Exception("Brod not found"));

        Zalba zalba = new Zalba(zalbaOpis, null, null, brod);

        zalbaRepository.save(zalba);
        return true;
    }

    public boolean createZalbaZaVikendicu(Principal principal,
                                          Long vikendicaId,
                                          String zalbaOpis) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if(user == null){
            throw new Exception("User not found");
        }

        Vikendica vikendica = vikendicaRepository.findById(vikendicaId)
                .orElseThrow(() -> new Exception("Vikendica not found"));

        Zalba zalba = new Zalba(zalbaOpis, vikendica, null, null);

        zalbaRepository.save(zalba);
        return true;
    }

    public boolean createZalbaZaCas(Principal principal,
                                    Long casId,
                                    String zalbaOpis) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if(user == null){
            throw new Exception("User not found");
        }

        Cas cas = casRepository.findById(casId)
                .orElseThrow(() -> new Exception("Cas not found"));

        Zalba zalba = new Zalba(zalbaOpis, null, cas, null);

        zalbaRepository.save(zalba);
        return true;
    }

    public List<Zalba> getAllZalbe(Principal principal) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if(user == null){
            throw new Exception("User not found");
        }
        if(!user.getRole().equals(Role.ROLE_ADMIN)){
            throw new Exception("Authentificatio faild");
        }

        List<Zalba> zalbe = zalbaRepository.findAll();

        List<Zalba> filterZalbe = zalbe
                .stream()
                .filter((zalba) -> zalba.isOdgovoreno() == false)
                .collect(Collectors.toList());

        return filterZalbe;

    }

}
