package com.example.Email.Consumer;

import com.example.Email.Models.EmailModel;
import com.example.Email.Service.EmailService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerEmail {
    final EmailService emailService;

    public ConsumerEmail(EmailService emailService){
        this.emailService = emailService;
    }
    @JmsListener(destination = "cadastro")
    public void listener(String cadastro){
        String[] data = cadastro.split(",");

        String nome = data[1].replace("nome=","");
        nome = nome.replace("'", "");

        String email = data[3].replace("email=","");
        email = email.replace("'", "");

        EmailModel emailModel = new EmailModel();

        emailModel.setName(nome);
        emailModel.setEmailTO(email);
        emailModel.setSubject("Cadastro realizado com sucesso!");
        emailModel.setText("Parabéns" + nome + " por se inscrever no nosso App!");

        emailService.sendEmail(emailModel);
    }
}
