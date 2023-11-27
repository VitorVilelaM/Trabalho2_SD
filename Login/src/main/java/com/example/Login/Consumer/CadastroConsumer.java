package com.example.Login.Consumer;

import com.example.Login.Database.RepositorioLogin;
import com.example.Login.Entidades.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CadastroConsumer {

    @Autowired
    private RepositorioLogin repositorio;
    @JmsListener(destination = "cadastroLogin")
    public void listener(String cadastro){
        Login dataLogin = new Login();

        String[] data = cadastro.split(",");

        String email = data[3].replace(" email=","");
        email = email.replace("'", "");

        String senha = data[4].replace(" senha=","");
        senha = senha.replace("'", "");
        senha = senha.replace("}", "");

        dataLogin.setEmail(email);
        dataLogin.setSenha(senha);

        repositorio.save(dataLogin);
    }
}
