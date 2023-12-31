package com.example.Login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ServiceLogin {
    private final JmsTemplate jmsTemplate;
    @Autowired
    public ServiceLogin(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }

    public void login(String login){
        jmsTemplate.convertAndSend("loginConta",login);
    }

}
