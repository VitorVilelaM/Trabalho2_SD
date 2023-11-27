package com.example.Cadastro.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class CadastroService {
    private final JmsTemplate jmsTemplate;
    @Autowired
    public CadastroService(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }

    public void sendUserLogin(String user){
        jmsTemplate.convertAndSend("cadastroLogin",user);
    }

    public void sendUserConta(String user){
        jmsTemplate.convertAndSend("cadastroConta",user);
    }

    public void sendUserEmail(String user){
        jmsTemplate.convertAndSend("cadastroEmail", user);
    }
}

