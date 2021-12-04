package com.example.ISA2021.Controllers;


import com.example.ISA2021.Models.Request.RequestUser;
import com.example.ISA2021.Models.User;
import com.example.ISA2021.Repository.UserRepository;
import com.example.ISA2021.Utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

   // @Autowired
    private UserRepository userRepository;

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
    public String signUp(@RequestBody User user){
        User u = userRepository.findByUsername(user.getUsername());
//        System.out.println("user");
//        System.out.println(u);
        if(u == null){
//            Ovde dodati validatore
            userRepository.save(user);
            return "User successfully Sign Up";
        }else{
            return "User with this username already exists";
        }
    }
}
