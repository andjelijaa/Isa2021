package com.example.backend.services;
import com.example.backend.models.Cas;
import com.example.backend.models.Role;
import com.example.backend.models.User;
import com.example.backend.models.response.GetCasDTO;
import com.example.backend.repository.CasRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class CasService {

    private final CasRepository casRepository;
    private final UserService userService;

    public CasService(CasRepository casRepository, UserService userService) {
        this.casRepository = casRepository;
        this.userService = userService;
    }

    public List<Cas> getAllCasovi(Principal principal) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if(user == null){
            throw new Exception("User not found");
        }
        List<Cas> casovi = casRepository.findAll();
        return casovi;
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
}