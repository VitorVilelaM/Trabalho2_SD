package com.example.Login.Controller;

import com.example.Login.Database.RepositorioLogin;
import com.example.Login.Entidades.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private RepositorioLogin repositorio;

    @PostMapping
    public String verificaOnline(@RequestBody Login login){

        List<Login> logins = repositorio.findAll();

        String email = login.getEmail().replace(" email=","");
        email = email.replace("'", "");

        String senha = login.getSenha().replace(" senha=","");
        senha = senha.replace("'", "");

        for(Login log : logins){
            if(log.getEmail().equals(login.getEmail())){
                return "Sucesso no login!";
            }
        }
        return "Usuário não existe!";
    }
}
