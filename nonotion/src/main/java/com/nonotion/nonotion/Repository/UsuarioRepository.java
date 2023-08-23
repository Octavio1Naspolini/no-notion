package com.nonotion.nonotion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nonotion.nonotion.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNome(String nome);
}
