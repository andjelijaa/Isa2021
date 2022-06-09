package com.example.backend.controllers;


import com.example.backend.models.*;
import com.example.backend.models.response.IndexDto;
import com.example.backend.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController("/api")
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public IndexDto getIndex(Principal principal){
        User user = userService.getActivatedUserFromPrincipal(principal);
        IndexDto response = null;
        if(user == null){
            response = new IndexDto(Role.ROLE_KORISNIK.name());
            return response;
        }

        response = new IndexDto(user.getRole().name());
        return response;
    }


}