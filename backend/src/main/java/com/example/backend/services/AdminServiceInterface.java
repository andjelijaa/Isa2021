package com.example.backend.services;

import com.example.backend.models.User;

public interface AdminServiceInterface {

    void notifyAdmin(User user, String link, String obrazlozenje);
}