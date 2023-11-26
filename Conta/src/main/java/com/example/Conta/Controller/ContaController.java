package com.example.Conta.Controller;

import com.example.Conta.Database.RepositorioConta;
import com.example.Conta.Entidades.Conta;
import com.example.Conta.Entidades.Transacao;
import com.example.Conta.Services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContaController {

    @Autowired
    private RepositorioConta repositorio;

    @Autowired
    private ContaService contaService;
    @GetMapping("/conta/{cpf}")
    public String verSaldo(@PathVariable String cpf){

        List<Conta> contas = repositorio.findAll();

        for(Conta count : contas){
            System.out.println(count.getCpf());
            if(count.getCpf().equals(cpf)){
                return "Saldo na conta: "+count.getValor();
            }
        }
        return "Não existe essa conta!";
    }
    @PostMapping("/pagar")
    public String pagar(@RequestBody Transacao transacao){

        List<Conta> contas = repositorio.findAll();

        String receptor = "", pagador = "";

        for(Conta count : contas){
            if(count.getCpf().equals(transacao.getPagador())){
                pagador = transacao.getPagador();
            }
        }

        if(transacao.getPagador().isEmpty()){
            return "Não existe a conta de pagador!";
        }

        for(Conta count : contas){
            if(count.getCpf().equals(transacao.getReceptor())){
                receptor = transacao.getPagador();
            }
        }

        if(transacao.getReceptor().isEmpty()){
            return "Não existe a conta de receptor!";
        }

        if(transacao.getValor().isEmpty()){
            return "Valor da transacao nao informado!";
        }

        contaService.mandaPagamento(transacao, contas);
        return "";

    }


}
