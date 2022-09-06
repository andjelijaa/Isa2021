package com.example.backend.controllers;

import com.example.backend.models.User;
import com.example.backend.models.request.BrisanjeNalogaDTO;
import com.example.backend.models.request.UpdateUserDTO;
import com.example.backend.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public User updateUser(Principal principal,
                           @RequestBody UpdateUserDTO updateUserDTO) throws Exception {

        return userService.updateUser(principal, updateUserDTO);
    }


    @PostMapping("/brisanjeNaloga")
    public boolean zahtevZaBrisanjeNaloga(Principal principal,
                                          @RequestBody BrisanjeNalogaDTO brisanjeNalogaDto){
        return userService.zahtevZaBrisanjeNaloga(principal, brisanjeNalogaDto);
    }
}