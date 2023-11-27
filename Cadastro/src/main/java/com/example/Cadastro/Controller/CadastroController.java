package com.example.Cadastro.Controller;

import com.example.Cadastro.Database.RepositorioCadastro;
import com.example.Cadastro.Entidades.Cadastro;
import com.example.Cadastro.Service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {
    @Autowired
    private RepositorioCadastro repositorio;

    @Autowired
    private CadastroService sendService;

    @PostMapping
    public void salvar(@RequestBody Cadastro cadastro){
        repositorio.save(cadastro);

        sendService.sendUserConta(cadastro.toString());
        sendService.sendUserLogin(cadastro.toString());
        sendService.sendUserEmail(cadastro.toString());
    }
}
