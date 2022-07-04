package com.example.backend.controllers;

import com.example.backend.models.User;
import com.example.backend.models.request.UpdateUserDTO;
import com.example.backend.services.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public void updateUser(Principal principal,
                           @RequestBody UpdateUserDTO updateUserDTO) throws Exception {
        User user = userService.getActivatedUserFromPrincipal(principal);
        if(user == null){
            throw new Exception("User not found");
        }

        if(updateUserDTO.getDrzava() != null){
            user.setDrzava(updateUserDTO.getDrzava());
        }
        if(updateUserDTO.getGrad() != null){
            user.setGrad(updateUserDTO.getGrad());
        }
        if(updateUserDTO.getUsername() != null){
            user.setUsername(updateUserDTO.getUsername());
        }
        if(updateUserDTO.getPassword() != null){
            user.setPassword(updateUserDTO.getPassword());
        }
        if(updateUserDTO.getIme() != null){
            user.setIme(updateUserDTO.getIme());
        }
        if(updateUserDTO.getPrezime() != null){
            user.setPrezime(updateUserDTO.getPrezime());
        }
        if(updateUserDTO.getPhone() != null){
            user.setPhone(updateUserDTO.getPhone());
        }
        userService.save(user);

    }
}