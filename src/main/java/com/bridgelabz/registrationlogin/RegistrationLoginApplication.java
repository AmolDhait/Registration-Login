package com.bridgelabz.registrationlogin;

import com.bridgelabz.registrationlogin.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class RegistrationLoginApplication {

    @Autowired
    private EmailSenderService emailSenderService;
    public static void main(String[] args) {
        SpringApplication.run(RegistrationLoginApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail(){

        emailSenderService.sendSimpleEmail("amol.dhait97@gmail.com",
                                             "this is body",
                                              "this is subject");

    }

}
