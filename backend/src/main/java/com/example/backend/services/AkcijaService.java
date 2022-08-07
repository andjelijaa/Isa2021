package com.example.backend.services;

import com.example.backend.models.Akcija;
import com.example.backend.models.Brod;
import com.example.backend.models.Cas;
import com.example.backend.models.Vikendica;
import com.example.backend.models.request.AkcijaRequestDTO;
import com.example.backend.repository.BrodRepository;
import com.example.backend.repository.CasRepository;
import com.example.backend.repository.VikendicaRepository;
import org.springframework.stereotype.Service;

@Service
public class AkcijaService {

    private final BrodRepository brodRepository;
    private final CasRepository casRepository;
    private final VikendicaRepository vikendicaRepository;

    public AkcijaService(BrodRepository brodRepository,CasRepository casRepository,VikendicaRepository vikendicaRepository) {
        this.brodRepository = brodRepository;
        this.casRepository=casRepository;
        this.vikendicaRepository=vikendicaRepository;
    }

    public Brod addAkcijaToBrod(Long brodId, AkcijaRequestDTO akcijaRequestDTO) throws Exception {
        Brod brod = brodRepository.findById(brodId)
                .orElseThrow(() -> new Exception("Brod not found"));
        brod.setAkcija(new Akcija(akcijaRequestDTO));

        return brodRepository.save(brod);
    }

    public Vikendica addAkcijaToVikendica(Long vikendicaId, AkcijaRequestDTO akcijaRequestDTO) throws Exception {
        Vikendica vikendica = vikendicaRepository.findById(vikendicaId)
                .orElseThrow(() -> new Exception("Vikendica not found"));
        vikendica.setAkcija(new Akcija(akcijaRequestDTO));

        return vikendica;
    }

    public Cas addAkcijaToCas(Long casId,AkcijaRequestDTO akcijaRequestDTO) throws Exception {
        Cas cas = casRepository.findById(casId)
                .orElseThrow(() -> new Exception("Cas not found"));
        cas.setAkcija(new Akcija(akcijaRequestDTO));

        return cas;
    }
}