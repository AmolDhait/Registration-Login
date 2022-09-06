package com.bridgelabz.registrationlogin.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class JwtResponse {

    String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public JwtResponse() {
    }
}
