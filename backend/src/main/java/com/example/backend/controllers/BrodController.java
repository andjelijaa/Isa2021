package com.example.backend.controllers;

import com.example.backend.models.Brod;
import com.example.backend.models.mappers.BrodMapper;
import com.example.backend.models.response.BrodDTO;
import com.example.backend.models.response.GetBrodDTO;
import com.example.backend.services.BrodService;
import com.example.backend.services.ZalbaService;
import org.springframework.web.bind.annotation.*;
import com.example.backend.models.request.CreateZalbaDTO;

import java.security.Principal;
import java.util.List;


@RestController("/api/brod")
public class BrodController {

    private final BrodService brodService;
    private final ZalbaService zalbaService;

    public BrodController(BrodService brodService, ZalbaService zalbaService) {
        this.brodService = brodService;
        this.zalbaService=zalbaService;

    }

    @RequestMapping(value = "/getAllBrodovi", method = RequestMethod.GET)
    public List<BrodDTO> getAll(Principal principal,
                                @RequestParam(name = "sort", defaultValue = "id") String sort,
                                @RequestParam(name = "type" , defaultValue = "1") int type) throws Exception {
        return BrodMapper.toDto(brodService.getAllBrodovi(principal, sort, type));
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

    @PostMapping("/zalba/{brodId}")
    public boolean createZalba(Principal principal,
                               @PathVariable(name = "brodId") Long brodId,
                               @RequestBody CreateZalbaDTO zalba) throws Exception {
        return zalbaService.createZalbaZaEntitet(principal, brodId, zalba);
    }
}