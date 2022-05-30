package com.example.backend.services;

import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Random;

@Service
public class EmailService {

    public static String generateActivationCode(){
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }

    public static void sendEmailToUser(String email, String link){
        System.out.println("posalje se mejl");
    }
}
