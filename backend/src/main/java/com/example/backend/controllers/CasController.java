package com.example.backend.controllers;

import com.example.backend.models.Cas;
import com.example.backend.models.Role;
import com.example.backend.models.User;
import com.example.backend.models.response.GetCasDTO;
import com.example.backend.repository.CasRepository;
import com.example.backend.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.security.Principal;
import java.util.Optional;

@RestController("/api/cas")
public class CasController {

    private final CasRepository casRepository;
    private final UserService userService;

    public CasController(CasRepository casRepository,
                         UserService userService) {
        this.casRepository = casRepository;
        this.userService = userService;
    }

    @GetMapping("/getAllCas")
    public List<Cas> getAll(Principal principal) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if(user == null){
            throw new Exception("User not found");
        }
        List<Cas> casovi = casRepository.findAll();
        return casovi;
    }

    @GetMapping("/{casId}")
    public GetCasDTO getCas(Principal principal,
                            @PathVariable(name = "casId") Long casId) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if (user == null) {
            throw new Exception("User not found");
        }
        Optional<Cas> cas = casRepository.findById(casId);
        if (cas.isEmpty()) {
            throw new Exception("Vikendica not found");
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
