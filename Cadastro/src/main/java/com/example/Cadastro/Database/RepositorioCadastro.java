package com.example.Cadastro.Database;

import com.example.Cadastro.Entidades.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositorioCadastro extends JpaRepository<Cadastro, UUID> {

}
