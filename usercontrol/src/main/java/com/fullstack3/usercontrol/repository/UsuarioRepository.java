package com.fullstack3.usercontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack3.usercontrol.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByCorreoUsuario(String correoUsuario);
}