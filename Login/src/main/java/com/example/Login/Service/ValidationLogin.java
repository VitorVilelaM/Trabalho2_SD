package com.example.Login.Service;

import com.example.Login.Database.RepositorioLogin;
import com.example.Login.Entidades.Login;

import java.util.List;

public class ValidationLogin {

    public Login validar(Login login, RepositorioLogin repositorio){

        List<Login> logins = repositorio.findAll();

        String email = login.getEmail().replace(" email=","");
        email = email.replace("'", "");

        String senha = login.getSenha().replace(" senha=","");
        senha = senha.replace("'", "");

        for(Login log : logins){
            if(log.getEmail().equals(login.getEmail())){
                return login;
            }
        }

        return null;
    }
}
