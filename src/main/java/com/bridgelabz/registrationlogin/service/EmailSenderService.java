package com.bridgelabz.registrationlogin.service;

import com.bridgelabz.registrationlogin.entity.Role;
import com.bridgelabz.registrationlogin.entity.User;
import com.bridgelabz.registrationlogin.repository.UserRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleEmail(String toEmail, String body, String subject){
//        User user = userRepository.findByEmail(toEmail);
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("amol.dhait97@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        javaMailSender.send(message);
        System.out.println("mail send..");
    }

}
