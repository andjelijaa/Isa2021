package com.example.backend.controllers;

import com.example.backend.models.Brod;
import com.example.backend.models.response.GetBrodDTO;
import com.example.backend.services.BrodService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController("/api/brod")
public class BrodController {

    private final BrodService brodService;

    public BrodController(BrodService brodService) {
        this.brodService = brodService;

    }

    @RequestMapping(value = "/getAllBrodovi", method = RequestMethod.GET)
    public List<Brod> getAll(Principal principal) throws Exception {
        return brodService.getAllBrodovi(principal);
    }

    @GetMapping("/{brodId}")
    public GetBrodDTO getBrod(Principal principal,
                              @PathVariable(name = "brodId") Long brodId) throws Exception {
        return brodService.getBrodByBrodId(principal, brodId);
    }

    @PostMapping("/create")
    public Brod createBrod(Principal principal,
                           @RequestBody Brod brod) throws Exception {
        return brodService.createBrod(principal, brod);
    }
}