package com.example.finalprojectbackend.lab2you.service;


import com.example.finalprojectbackend.lab2you.db.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

   private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendRegistrationEmail(UserEntity userEntity) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userEntity.getEmail());
        message.setSubject("Welcome to lab2you!");
        message.setText("Hello " + userEntity.getName() + " " + userEntity.getLastName()
                + ",\n\n" + "Your account has been created successfully.\n\n"
                + "Your username is: "
                + userEntity.getEmail() + "\n" + "Your password is: "
                + userEntity.getPassword() + "\n\n" + "Thank you for choosing lab2you where we make your life easier!\n\n"
                + "Best regards,\n"
                + "lab2you team");
        javaMailSender.send(message);
    }
}
