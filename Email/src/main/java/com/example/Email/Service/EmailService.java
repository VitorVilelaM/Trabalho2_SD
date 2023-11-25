package com.example.Email.Service;

import com.example.Email.Models.EmailModel;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
    final JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender){
        this.emailSender = emailSender;
    }

    public void sendEmail(EmailModel emailModel){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailModel.getEmailTO());
        message.setSubject(emailModel.getSubject());
        message.setText(emailModel.getText());
        emailSender.send(message);
    }

}
