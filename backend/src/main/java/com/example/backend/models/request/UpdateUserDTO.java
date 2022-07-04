package com.example.backend.models.request;


import lombok.Data;

@Data
public class UpdateUserDTO {
    private String username;
    private String password;
    private String ime;
    private String prezime;
    private String grad;
    private String drzava;
    private String phone;
}