package com.example.Conta.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Conta {
    private String email;
    private final String agencia = "1000";

    private final String digitoConta = "010";
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numConta;
    @Id
    private String cpf;
    private Double valor = 0.00 ;

    private Enum logado ;

    public Enum getLogado() {
        return logado;
    }

    public void setLogado(Enum logado) {
        this.logado = logado;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
