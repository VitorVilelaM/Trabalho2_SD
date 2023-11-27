package com.example.Conta.Entidades;

public class Deposito {
    private String valor;
    private String destino;

    @Override
    public String toString() {
        return "Deposito," +
                "valor='" + valor + '\'' +
                ", destino='" + destino + '\'' +
                '}';
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
