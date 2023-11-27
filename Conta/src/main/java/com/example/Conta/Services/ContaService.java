package com.example.Conta.Services;

import com.example.Conta.Database.RepositorioConta;
import com.example.Conta.Entidades.Conta;
import com.example.Conta.Entidades.Deposito;
import com.example.Conta.Entidades.Transacao;
import com.example.Conta.Enums.Logado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class ContaService {

    public String mandaPagamento(Transacao transacao, List<Conta> contas, RepositorioConta repositorio){
        Conta pagador = null, receptor = null;
        Double valorTransacao = Double.parseDouble(transacao.getValor());

        if(valorTransacao <= 0){
            return "valor_zero";
        }

        for(Conta count : contas){
            if(count.getCpf().equals(transacao.getPagador())){
                pagador = count;

                if(pagador.getValor() < valorTransacao){
                    return "valor_insuficiente";
                }
                pagador.setValor(pagador.getValor()-valorTransacao);
                repositorio.save(pagador);
            }
        }

        if(pagador != null && pagador.getLogado() != Logado.SIM){
            return "";
        }



        for(Conta count : contas){
            if(count.getCpf().equals(transacao.getReceptor())){
                receptor = count;

                if(pagador != null && receptor != null && pagador.getCpf().equals(receptor.getCpf())){
                    return "iguais";
                }

                receptor.setValor(receptor.getValor()+valorTransacao);
                repositorio.save(receptor);
                break;
            }
        }



        return "Sucesso!";
    }

    public String deposita(Deposito deposito, List<Conta> contas, RepositorioConta repositorio){
       Conta destino;
       for(Conta count: contas){
           if(count.getCpf().equals(deposito.getDestino())){
               destino = count;

               if(destino.getLogado() != Logado.SIM){
                   return "";
               }
               destino.setValor(destino.getValor()+(Double.parseDouble(deposito.getValor())));
               //email.sendEmail(deposito.toString() + "," + destino.getEmail());
               repositorio.save(destino);
               break;
           }

       }
       return "Sucesso";
    }


}
