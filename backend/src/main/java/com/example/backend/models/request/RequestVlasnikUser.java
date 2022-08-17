package com.example.backend.models.request;

import com.example.backend.models.User;
import lombok.Data;


public class RequestVlasnikUser {
    private User user;
    private String obrazlozenje;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getObrazlozenje() {
        return obrazlozenje;
    }

    public void setObrazlozenje(String obrazlozenje) {
        this.obrazlozenje = obrazlozenje;
    }
}