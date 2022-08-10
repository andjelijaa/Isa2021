package com.example.backend.services;

import com.example.backend.models.Akcija;
import com.example.backend.models.Brod;
import com.example.backend.models.Cas;
import com.example.backend.models.Vikendica;
import com.example.backend.models.request.AkcijaRequestDTO;
import com.example.backend.models.request.UpdateAkcijaDTO;
import com.example.backend.repository.AkcijaRepository;
import com.example.backend.repository.BrodRepository;
import com.example.backend.repository.CasRepository;
import com.example.backend.repository.VikendicaRepository;
import org.springframework.stereotype.Service;

@Service
public class AkcijaService {

    private final BrodRepository brodRepository;
    private final CasRepository casRepository;
    private final VikendicaRepository vikendicaRepository;
    private final AkcijaRepository akcijaRepository;

    public AkcijaService(BrodRepository brodRepository,CasRepository casRepository,VikendicaRepository vikendicaRepository,AkcijaRepository akcijaRepository) {
        this.brodRepository = brodRepository;
        this.casRepository=casRepository;
        this.vikendicaRepository=vikendicaRepository;
        this.akcijaRepository=akcijaRepository;
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

        return vikendicaRepository.save(vikendica);
    }

    public Cas addAkcijaToCas(Long casId,AkcijaRequestDTO akcijaRequestDTO) throws Exception {
        Cas cas = casRepository.findById(casId)
                .orElseThrow(() -> new Exception("Cas not found"));
        cas.setAkcija(new Akcija(akcijaRequestDTO));

        return casRepository.save(cas);
    }

    public Brod deleteAkcijuBrod(Long brodId) throws Exception {
        Brod brod = brodRepository.findById(brodId)
                .orElseThrow(() -> new Exception("Brod not found"));
        Akcija akcija = brod.getAkcija();
        akcijaRepository.delete(akcija);
        brod.setAkcija(null);

        return brodRepository.save(brod);
    }

    public Vikendica deleteAkcijuVikendica(Long vikendicaId) throws Exception {
        Vikendica vikendica = vikendicaRepository.findById(vikendicaId)
                .orElseThrow(() -> new Exception("Brod not found"));
        Akcija akcija = vikendica.getAkcija();
        akcijaRepository.delete(akcija);
        vikendica.setAkcija(null);

        return vikendicaRepository.save(vikendica);
    }

    public Brod updateAkcijaBrod(Long brodId,
                                 UpdateAkcijaDTO updateAkcijaDTO) throws Exception {
        Brod brod = brodRepository.findById(brodId)
                .orElseThrow(() -> new Exception("Brod not found"));
        Akcija akcija = brod.getAkcija();
        if(updateAkcijaDTO.getDatumOd() != null){
            akcija.setDatumOd(updateAkcijaDTO.getDatumOd());
        }
        if(updateAkcijaDTO.getDatumDo() != null){
            akcija.setDatumDo(updateAkcijaDTO.getDatumDo());
        }
        brod.setAkcija(akcija);

        return brodRepository.save(brod);
    }

    public Vikendica updateAkcijaVikendica(Long vikendicaId,
                                           UpdateAkcijaDTO updateAkcijaDTO) throws Exception {
        Vikendica vikendica = vikendicaRepository.findById(vikendicaId)
                .orElseThrow(() -> new Exception("Vikendica not found"));
        Akcija akcija = vikendica.getAkcija();
        if(updateAkcijaDTO.getDatumOd() != null){
            akcija.setDatumOd(updateAkcijaDTO.getDatumOd());
        }
        if(updateAkcijaDTO.getDatumDo() != null){
            akcija.setDatumDo(updateAkcijaDTO.getDatumDo());
        }
        vikendica.setAkcija(akcija);

        return vikendicaRepository.save(vikendica);
    }



}