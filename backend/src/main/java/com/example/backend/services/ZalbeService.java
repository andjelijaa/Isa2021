package com.example.backend.services;

import com.example.backend.models.Brod;
import com.example.backend.models.User;
import com.example.backend.models.Zalba;
import com.example.backend.repository.BrodRepository;
import com.example.backend.repository.CasRepository;
import com.example.backend.repository.VikendicaRepository;
import com.example.backend.repository.ZalbaRepository;
import org.springframework.stereotype.Service;

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
}
