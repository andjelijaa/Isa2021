package com.example.backend.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PenaliScheduling {

    private UserService userService;

    @Scheduled(cron="* * 1 * *")
    public void ScheduleRemovePenali(){
        userService.removePenaleForAllUsers();
    }
}