package com.example.backend.services;

import com.example.backend.models.User;
import com.example.backend.models.request.BrisanjeNalogaDTO;

import java.security.Principal;

public interface UserServiceInterface {
    User checkActivationCode(String code);
    User findByUsername(String username);
    void save(User user);
    boolean zahtevZaBrisanjeNaloga(Principal principal, BrisanjeNalogaDTO brisanjeNalogaDto);

}