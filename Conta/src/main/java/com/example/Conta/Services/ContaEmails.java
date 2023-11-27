package com.example.Conta.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ContaEmails {

    @Autowired
    private final JmsTemplate jmsTemplate;

    @Autowired
    public ContaEmails(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendEmail(String operacao){
        jmsTemplate.convertAndSend("operacaoEmail", operacao);
    }
}
