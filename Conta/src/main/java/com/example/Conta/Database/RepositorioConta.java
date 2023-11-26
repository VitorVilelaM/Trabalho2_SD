package com.example.Conta.Database;

import com.example.Conta.Entidades.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioConta extends JpaRepository<Conta, String> {

}
