package com.example.backend.services;

import com.example.backend.models.User;
import com.example.backend.models.request.UpdateUserDTO;
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

    public User updateUser(Principal principal, UpdateUserDTO updateUserDTO) throws Exception {
        User user = getActivatedUserFromPrincipal(principal);
        if(user == null){
            throw new Exception("User not found");
        }

        if(updateUserDTO.getDrzava() != null){
            user.setDrzava(updateUserDTO.getDrzava());
        }
        if(updateUserDTO.getGrad() != null){
            user.setGrad(updateUserDTO.getGrad());
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
        if (updateUserDTO.getAdresa() != null){
            user.setAddress(updateUserDTO.getAdresa());
        }
        return userRepository.save(user);
    }
}
