package com.example.Conta.Controller;

import com.example.Conta.Database.RepositorioConta;
import com.example.Conta.Entidades.Conta;
import com.example.Conta.Entidades.Deposito;
import com.example.Conta.Entidades.Transacao;
import com.example.Conta.Services.ContaEmails;
import com.example.Conta.Services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContaController {

    @Autowired
    private RepositorioConta repositorio;

    @Autowired
    private ContaEmails email;

    ContaService contaService = new ContaService();

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

        Conta receptor = null, pagador = null;

        for(Conta count : contas){
            if(count.getCpf().equals(transacao.getPagador())){
                pagador = count;
            }
        }

        if(pagador != null && pagador.getCpf().isEmpty()){
            return "Não existe a conta de pagador!";
        }

        for(Conta count : contas){
            if(count.getCpf().equals(transacao.getReceptor())){
                receptor = count;
            }
        }

        if(receptor.getCpf().isEmpty()){
            return "Não existe a conta de receptor!";
        }

        if(transacao.getValor().isEmpty()){
            return "Valor da transacao nao informado!";
        }

        String pagamento = contaService.mandaPagamento(transacao, contas,repositorio);

        if(pagamento.isEmpty()){
            return "Você não está logado!";
        }else if(pagamento.equals("valor_insuficiente")){
            return "Você não possui valor suficiente para essa transação!";
        }else if(pagamento.equals("valor_zero")){
            return "Impossivel fazer transação de nenhum valor!";
        }else if(pagamento.equals("iguais")){
            return "Você esta tentando pagar você mesmo?";
        }

        email.sendEmail(transacao.toString() +","+ receptor.getEmail());

        return "Pagamento feito com sucesso!";

    }

    @PostMapping("/depositar")
    public String pagar(@RequestBody Deposito deposito){
        List<Conta> contas = repositorio.findAll();

        String destino = "";

        for(Conta count : contas){
            if(count.getCpf().equals(deposito.getDestino())){
                destino = deposito.getDestino();
            }
        }

        if(destino.isEmpty()){
            return "Nao existe conta a esse CPF";
        }

        contaService.deposita(deposito, contas, repositorio);

        return "Deposito feito com sucesso!";
    }

}
