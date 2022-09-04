package com.example.backend.services;

import com.example.backend.models.Role;
import com.example.backend.models.User;
import com.example.backend.models.Vikendica;
import com.example.backend.models.response.GetVikendicaDTO;
import com.example.backend.repository.VikendicaRepository;
import com.example.backend.utils.VikendicaSortingHelper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class VikendicaService {

    public final VikendicaRepository vikendicaRepository;
    public final UserService userService;
    private final RezervacijaService rezervacijaService;
    private final VikendicaSortingHelper vikendicaSortingHelper;


    public VikendicaService(VikendicaRepository vikendicaRepository, UserService userService, RezervacijaService rezervacijaService, VikendicaSortingHelper vikendicaSortingHelper) {
        this.vikendicaRepository = vikendicaRepository;
        this.userService = userService;
        this.rezervacijaService=rezervacijaService;
        this.vikendicaSortingHelper=vikendicaSortingHelper;
    }

    public List<Vikendica> getAllVikendice(Principal principal, String sort, String value) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if (user == null) {
            throw new Exception("User not found");
        }
        List<Vikendica> vikendice = vikendicaSortingHelper.getSortedVikendice(sort, value);
        return vikendice;
    }

    public GetVikendicaDTO getVikendicaByVikendicaId(Principal principal, Long vikendicaId) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if (user == null) {
            throw new Exception("User not found");
        }
        Optional<Vikendica> vikendica = vikendicaRepository.findById(vikendicaId);
        if (vikendica.isEmpty()) {
            throw new Exception("Vikendica not found");
        }
        GetVikendicaDTO response = null;
        if (Role.ROLE_VLASNIK_VIKENDICE == user.getRole() && vikendica.get().getVlasnik().getUsername().equals(user.getUsername())) {
            response = new GetVikendicaDTO(
                    vikendica.get(),
                    true
            );
            return response;
        }
        response = new GetVikendicaDTO(
                vikendica.get(),
                false
        );
        return response;
    }

    public Vikendica createVikendica(Principal principal, Vikendica vikendica) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if (user == null) {
            throw new Exception("User not found");
        }

        if (Role.ROLE_VLASNIK_VIKENDICE == user.getRole()) {
            vikendica.setVlasnik(user);
            return vikendicaRepository.save(vikendica);
        }
        return null;
    }

    public Vikendica oceniVikendic(Principal principal, Long vikendicaId, Long ocena) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        Vikendica vikendica = vikendicaRepository.findById(vikendicaId)
                .orElseThrow(() -> new Exception("vikendica not found"));
        if (user == null) {
            throw new Exception("User not found");
        }
        if(rezervacijaService.isUserHaveRezervation(user, vikendica)){
            vikendica.setBrojOcena(vikendica.getBrojOcena() + 2);
            vikendica.setOcena((vikendica.getOcena() + ocena) / vikendica.getBrojOcena());
            vikendicaRepository.save(vikendica);
            return vikendica;
        }
        return null;
    }

}
