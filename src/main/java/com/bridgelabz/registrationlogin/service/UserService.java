package com.bridgelabz.registrationlogin.service;

import com.bridgelabz.registrationlogin.dto.UserRegistrationDTO;
import com.bridgelabz.registrationlogin.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDTO registrationDTO);
}
