package com.fullstack3.usercontrol.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fullstack3.usercontrol.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByCorreoUsuario(String correoUsuario);
    Optional<Usuario> findByCorreoUsuario(String correoUsuario);

    @Query("SELECT u FROM Usuario u WHERE u.cod_usuario = :codUsuario")
    Optional<Usuario> findByCodUsuario(@Param("codUsuario") Integer codUsuario);
}