package com.example.Conta.Entidades;

public class Transacao {
    private String pagador;
    private String receptor;

    private String valor;

    @Override
    public String toString() {
        return "Pagamento," +
                "pagador='" + pagador + '\'' +
                ", receptor='" + receptor + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }

    public String getPagador() {
        return pagador;
    }

    public void setPagador(String pagador) {
        this.pagador = pagador;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
