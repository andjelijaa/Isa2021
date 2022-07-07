package com.example.backend.services;

import com.example.backend.models.User;
import com.example.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserService implements UserServiceInterface {
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getActivatedUserFromPrincipal(Principal principal){
        if(principal == null){
            return null;
        }
        User u = userRepository.findByUsername(principal.getName());
        if(u != null && u.getActivation() == null){
            return u;
        }
        return null;
    }

    @Override
    public User checkActivationCode(String code) {
        User user = userRepository.findByActivation(code);
        if(user == null){
            return null;
        }
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}