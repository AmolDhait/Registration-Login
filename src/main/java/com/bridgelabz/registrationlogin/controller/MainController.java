package com.bridgelabz.registrationlogin.controller;

import com.bridgelabz.registrationlogin.entity.JwtResponse;
import com.bridgelabz.registrationlogin.entity.Role;
import com.bridgelabz.registrationlogin.entity.User;
import com.bridgelabz.registrationlogin.helper.JwtUtil;
import com.bridgelabz.registrationlogin.service.UserService;
import com.bridgelabz.registrationlogin.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtUtil jwtUtil;


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }


    public String genrateEmail(@RequestBody User user)
    {
        String emilSender = new String(user.getEmail());
        return emilSender;
    }



    @PostMapping("/token")
    public ResponseEntity<?>generateToken(@RequestBody User user) throws Exception {
        System.out.println(user);

        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));


        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("Bad Credential");
        }catch(BadCredentialsException e)
        {
            e.printStackTrace();
            throw new Exception("Bad Credential");
        }

        UserDetails userDetails = this.userService.loadUserByUsername(user.getEmail());

         String token = this.jwtUtil.generateToken(userDetails);
         System.out.println("JWT " +token);

         return ResponseEntity.ok(new JwtResponse(token));

    }
}
