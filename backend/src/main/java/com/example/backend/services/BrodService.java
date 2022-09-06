package com.example.backend.services;


import com.example.backend.models.Brod;
import com.example.backend.models.Entitet;
import com.example.backend.models.Role;
import com.example.backend.models.User;
import com.example.backend.models.response.GetBrodDTO;
import com.example.backend.repository.BrodRepository;
import com.example.backend.utils.EntitetSortingHelper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrodService {
    private final UserService userService;
    private final BrodRepository brodRepository;
    private final EntitetSortingHelper entitetSortingHelper;

    public BrodService(UserService userService, BrodRepository brodRepository,EntitetSortingHelper entitetSortingHelper) {
        this.userService = userService;
        this.brodRepository = brodRepository;
        this.entitetSortingHelper=entitetSortingHelper;
    }

    public List<Brod> getAllBrodovi(Principal principal, String sort, int type) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if(user == null){
            throw new Exception("User not found");
        }
        Optional<List<Entitet>> brodovi = entitetSortingHelper.getSortedEntiteti(sort, type);
        List<Brod> brodoviReturn = brodovi
                .get()
                .stream()
                .map(entitet -> (Brod) entitet)
                .collect(Collectors.toList());
        return brodoviReturn;
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

    public Brod createBrod(Principal principal, Brod brod) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if (user == null) {
            throw new Exception("User not found");
        }

        if (Role.ROLE_VLASNIK_BRODA == user.getRole()) {
            brod.setVlasnik(user);
            return brodRepository.save(brod);
        }
        return null;
    }
}