package com.example.backend.models.request;

import com.example.backend.models.User;
import lombok.Data;

@Data
public class RequestVlasnikUser {
    private User user;
    private String obrazlozenje;
}