package com.example.backend.services;

import com.example.backend.models.Akcija;
import com.example.backend.models.Brod;
import com.example.backend.models.request.AkcijaRequestDTO;
import com.example.backend.repository.BrodRepository;
import org.springframework.stereotype.Service;

@Service
public class AkcijaService {

    private final BrodRepository brodRepository;

    public AkcijaService(BrodRepository brodRepository) {
        this.brodRepository = brodRepository;
    }

    public Brod addAkcijaToBrod(Long brodId, AkcijaRequestDTO akcijaRequestDTO) throws Exception {
        Brod b = brodRepository.findById(brodId)
                .orElseThrow(() -> new Exception("Brod not found"));
        b.setAkcija(new Akcija(akcijaRequestDTO));

        return brodRepository.save(b);
    }
    public void addAkcijaToVikendica(Long vikendicaId){}
    public void addAkcijaToCas(Long casId){}
}