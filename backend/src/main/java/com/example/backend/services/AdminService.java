package com.example.backend.services;

import com.example.backend.models.User;
import org.springframework.stereotype.Service;

@Service
public class AdminService  implements  AdminServiceInterface{
    @Override
    public void notifyAdmin(User user, String link, String obrazlozenje){

    }
    public void notifyAdminDaOpetRezervise() {
        System.out.println("Obavesti se admin da pogleda rezervacije");
    }
}
