package com.example.backend.controllers;


import com.example.backend.models.Role;
import com.example.backend.models.User;
import com.example.backend.models.request.RequestUser;
import com.example.backend.models.request.RequestVlasnikUser;
import com.example.backend.repository.UserRepository;
import com.example.backend.services.AdminService;
import com.example.backend.services.EmailService;
import com.example.backend.services.UserService;
import com.example.backend.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import javax.mail.MessagingException;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    private final UserService userService;
    private final AdminService adminService;


    public LoginController(UserService userService,
                           AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
    }

    @PostMapping("/signIn")
    public String genToken(@RequestBody RequestUser requestUser) throws Exception {
        System.out.println("requestUser");
        System.out.println(requestUser);
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestUser.getUsername(), requestUser.getPassword())
            );
        }catch (Exception ex){
            throw new Exception("invalid username or/and password");
        }
        return jwtUtils.generateToken(requestUser.getUsername());
    }

    @PostMapping("/signUp")
    public boolean signUp(@RequestBody User user) throws MessagingException {
        User u = userRepository.findByUsername(user.getUsername());
        if(u == null){
            user.setRole(Role.ROLE_KLIJENT);
            String activationCode = EmailService.generateActivationCode();
            String link = "http://localhost:8083/api/potvrdiEmail/" + activationCode;
            System.out.println("link");
            System.out.println(link);
            user.setActivation(activationCode);
            emailService.sendEmailActivationLinkToUser(user.getUsername(),link);
            user.setActivation(null); //TODO:Promeni kad proveris da li menja sigurno i u bazi            userRepository.save(user);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @GetMapping("/potvrdiEmail/{code}")
    public void potvrdiEmail(@PathVariable("code") String code){
        User user = userService.checkActivationCode(code);
        user.setActivation(null);
        userRepository.save(user);
    }

    @PostMapping("/signUpVlasnik")
    public boolean signUpVlasnik(@RequestBody RequestVlasnikUser user){
        System.out.println("requestVlasnikUser");
        User u = userRepository.findByUsername(user.getUser().getUsername());
        if(u == null){
            String activationCode = EmailService.generateActivationCode();
            String link = "http://localhost:8083/api/potvrdiEmail/" + activationCode;
            user.getUser().setActivation(activationCode);
            User newUser = userRepository.saveAndFlush(user.getUser());
            adminService.notifyAdmin(newUser, link, user.getObrazlozenje());
            return true;
        }
        return false;
    }
}


