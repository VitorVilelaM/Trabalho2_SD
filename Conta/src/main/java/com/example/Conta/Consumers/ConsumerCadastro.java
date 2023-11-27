package com.example.Conta.Consumers;

import com.example.Conta.Database.RepositorioConta;
import com.example.Conta.Entidades.Conta;
import com.example.Conta.Enums.Logado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerCadastro {

    @Autowired
    private RepositorioConta repositorio;

    @JmsListener(destination = "cadastroConta")
    public void listener(String cadastro){
        Conta conta = new Conta();

        String[] data = cadastro.split(",");

        String cpf = data[2].replace(" cpf=","");
        cpf = cpf.replace("'", "");

        String email = data[3].replace(" email=", "");
        email = email.replace("'", "");

        conta.setCpf(cpf);
        conta.setEmail(email);
        conta.setLogado(Logado.NAO);

        repositorio.save(conta);
    }

}
