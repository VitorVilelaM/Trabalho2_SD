package com.example.Conta.Services;

import com.example.Conta.Database.RepositorioConta;
import com.example.Conta.Entidades.Conta;
import com.example.Conta.Entidades.Transacao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContaService {
    @Autowired
    private RepositorioConta repositorio;

    public void mandaPagamento(Transacao transacao, List<Conta> contas){

        Conta pagador, receptor;
        for(Conta count : contas){
            if(count.getCpf().equals(transacao.getPagador())){
                pagador = count;
                pagador.setValor(pagador.getValor()-(Double.parseDouble(transacao.getValor())));
                repositorio.save(pagador);
            }
        }

        for(Conta count : contas){
            if(count.getCpf().equals(transacao.getReceptor())){
                receptor = count;
                receptor.setValor(receptor.getValor()+(Double.parseDouble(transacao.getValor())));
                repositorio.save(receptor);
            }
        }
    }


}
