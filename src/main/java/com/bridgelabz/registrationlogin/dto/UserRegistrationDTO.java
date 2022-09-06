package com.bridgelabz.registrationlogin.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter

public @Data class UserRegistrationDTO {

    private String firstName;
    private String lastname;
    private String email;
    private String password;

    public UserRegistrationDTO() {
    }

    public UserRegistrationDTO(String firstName, String lastname, String email, String password) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
}
