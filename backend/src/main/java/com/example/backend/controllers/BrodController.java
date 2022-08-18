package com.example.backend.controllers;

import com.example.backend.models.Brod;
import com.example.backend.models.mappers.BrodMapper;
import com.example.backend.models.response.BrodDTO;
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
    public List<BrodDTO> getAll(Principal principal) throws Exception {
        return BrodMapper.toDto(brodService.getAllBrodovi(principal));
    }

    @GetMapping("/{brodId}")
    public GetBrodDTO getBrod(Principal principal,
                              @PathVariable(name = "brodId") Long brodId) throws Exception {
        return brodService.getBrodByBrodId(principal, brodId);
    }

    @PostMapping("/createBrod")
    public BrodDTO createBrod(Principal principal,
                           @RequestBody Brod brod) throws Exception {
        return BrodMapper.INSTANCE.toDto(brodService.createBrod(principal, brod));
    }
}