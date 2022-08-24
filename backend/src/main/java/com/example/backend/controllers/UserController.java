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
    public User updateUser(Principal principal,
                           @RequestBody UpdateUserDTO updateUserDTO) throws Exception {

        return userService.updateUser(principal, updateUserDTO);
    }
}