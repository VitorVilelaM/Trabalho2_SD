package com.example.Login.Database;

import com.example.Login.Entidades.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioLogin extends JpaRepository<Login, String> {
}
