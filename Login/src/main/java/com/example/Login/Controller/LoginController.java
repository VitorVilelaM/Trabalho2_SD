package com.example.Login.Controller;

import com.example.Login.Database.RepositorioLogin;
import com.example.Login.Entidades.Login;
import com.example.Login.Service.ServiceLogin;
import com.example.Login.Service.ValidationLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private RepositorioLogin repositorio;

    @Autowired
    ServiceLogin sendService;

    @PostMapping
    public String verificaOnline(@RequestBody Login login){
        ValidationLogin validar = new ValidationLogin();

        Login valido = validar.validar(login, repositorio);
        if(valido != null){
            sendService.login(login.toString());
            return "Logado com sucesso!";
        }

        return "Usuário não existe!";
    }
}
