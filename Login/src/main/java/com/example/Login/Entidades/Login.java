package com.example.Login.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Login {
    @Id
    private String email;
    private String senha;

    @Override
    public String toString() {
        return "{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
