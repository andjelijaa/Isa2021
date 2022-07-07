package com.example.backend.services;

import com.example.backend.models.User;

public interface UserServiceInterface {
    User checkActivationCode(String code);
    User findByUsername(String username);
    void save(User user);
}