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

    public void sendUser(String user){
        jmsTemplate.convertAndSend("cadastro",user);
    }
}
