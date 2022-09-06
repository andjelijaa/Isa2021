package com.example.backend.services;
import com.example.backend.models.Cas;
import com.example.backend.models.Entitet;
import com.example.backend.models.Role;
import com.example.backend.models.User;
import com.example.backend.models.response.GetCasDTO;
import com.example.backend.repository.CasRepository;
import com.example.backend.utils.EntitetSortingHelper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CasService {

    private final CasRepository casRepository;
    private final UserService userService;
    private final EntitetSortingHelper entitetSortingHelper;

    public CasService(CasRepository casRepository, UserService userService, EntitetSortingHelper entitetSortingHelper) {
        this.casRepository = casRepository;
        this.userService = userService;
        this.entitetSortingHelper= entitetSortingHelper;
    }

    public List<Cas> getAllCasovi(Principal principal,String sort, int value) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if(user == null){
            throw new Exception("User not found");
        }
        Optional<List<Entitet>> entiteti = entitetSortingHelper.getSortedEntiteti(sort, value);
        List<Cas> casovi = entiteti
                .get()
                .stream()
                .map(entitet -> (Cas) entitet)
                .collect(Collectors.toList());        return casovi;
    }

    public GetCasDTO getCasByCasId(Principal principal, Long casId) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if (user == null) {
            throw new Exception("User not found");
        }
        Optional<Cas> cas = casRepository.findById(casId);
        if (cas.isEmpty()) {
            throw new Exception("Cas not found");
        }
        GetCasDTO response = null;
        if (Role.ROLE_INSTRUKTOR_PECANJA == user.getRole() && cas.get().getVlasnik().getUsername().equals(user.getUsername())) {
            response = new GetCasDTO(
                    cas.get(),
                    true
            );
            return response;
        }
        response = new GetCasDTO(
                cas.get(),
                false
        );
        return response;
    }

    public Cas createCas(Principal principal, Cas cas) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if (user == null) {
            throw new Exception("User not found");
        }

        if (Role.ROLE_INSTRUKTOR_PECANJA == user.getRole()) {
            cas.setVlasnik(user);
            return casRepository.save(cas);
        }
        return null;
    }
}