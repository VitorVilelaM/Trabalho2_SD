package com.example.Conta.Consumers;

import com.example.Conta.Database.RepositorioConta;
import com.example.Conta.Entidades.Conta;
import com.example.Conta.Enums.Logado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ConsumerLogin {

    @Autowired
    private RepositorioConta repositorio;

    @JmsListener(destination = "loginConta")
    public void listener(String login){

        List<Conta> counts = repositorio.findAll();

        Conta contaLogin;

        String[] data = login.split(",");

        String email = data[0].replace("{email=","");
        email = email.replace("'", "");

        for (Conta count : counts){
            if(count.getEmail().equals(email)){
                contaLogin = count;
                contaLogin.setLogado(Logado.SIM);
                repositorio.save(contaLogin);
            }
        }
    }
}
