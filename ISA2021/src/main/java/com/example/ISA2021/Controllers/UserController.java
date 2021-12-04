package com.example.ISA2021.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/index")
    public String index(){
        return "Ovde moze da dodje obican korisnik";
    }

    @GetMapping("/authTest")
    public String authTest(){
        return "Ovde moze da dodje samo registrovan korisnik";
    }

}
