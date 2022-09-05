package com.example.backend.controllers;

import com.example.backend.models.Zalba;
import com.example.backend.services.ZalbaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController("/api/admin")
public class AdminController {

    private final ZalbaService zalbaService;

    public AdminController(ZalbaService zalbaService) {
        this.zalbaService = zalbaService;
    }

    @GetMapping("/zalbe/all")
    public List<Zalba> getSveTrenutneZalbe(Principal principal) throws Exception {
        return zalbaService.getAllZalbe(principal);
    }
}