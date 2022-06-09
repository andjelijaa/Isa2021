package com.example.backend.controllers;

import com.example.backend.models.Brod;
import com.example.backend.models.Role;
import com.example.backend.models.User;
import com.example.backend.models.response.GetBrodDTO;
import com.example.backend.repository.BrodRepository;
import com.example.backend.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController("/api/brod")
public class BrodController {
    private final BrodRepository brodRepository;
    private final UserService userService;

    public BrodController(BrodRepository brodRepository, UserService userService) {
        this.brodRepository = brodRepository;
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<Brod> getAll(Principal principal) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if(user == null){
            throw new Exception("User not found");
        }
        List<Brod> brodovi = brodRepository.findAll();
        return brodovi;
    }

    @GetMapping("/{brodId}")
    public GetBrodDTO getBrod(Principal principal,
                              @PathVariable(name = "brodId") Long brodId) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if(user == null){
            throw new Exception("User not found");
        }
        Optional<Brod> brod = brodRepository.findById(brodId);
        if(brod.isEmpty()){
            throw new Exception("Vikendica not found");
        }
        GetBrodDTO response = null;
        if(Role.ROLE_VLASNIK_BRODA == user.getRole() && brod.get().getVlasnik().getUsername().equals(user.getUsername())){
            response = new GetBrodDTO(
                    brod.get(),
                    true
            );
            return response;
        }
        response = new GetBrodDTO(
                brod.get(),
                false
        );
        return response;
    }
}