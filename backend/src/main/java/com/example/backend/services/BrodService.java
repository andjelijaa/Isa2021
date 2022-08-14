package com.example.backend.services;


import com.example.backend.models.Brod;
import com.example.backend.models.Role;
import com.example.backend.models.User;
import com.example.backend.models.response.GetBrodDTO;
import com.example.backend.repository.BrodRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class BrodService {
    private final UserService userService;
    private final BrodRepository brodRepository;

    public BrodService(UserService userService, BrodRepository brodRepository) {
        this.userService = userService;
        this.brodRepository = brodRepository;
    }

    public List<Brod> getAllBrodovi(Principal principal) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if(user == null){
            throw new Exception("User not found");
        }
        List<Brod> brodovi = brodRepository.findAll();
        return brodovi;
    }

    public GetBrodDTO getBrodByBrodId(Principal principal, Long brodId) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if(user == null){
            throw new Exception("User not found");
        }
        Optional<Brod> brod = brodRepository.findById(brodId);
        if(brod.isEmpty()){
            throw new Exception("Brod not found");
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