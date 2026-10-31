package com.fullstack3.usercontrol.service;

import com.fullstack3.usercontrol.model.Usuario;
import java.util.List;


public interface UsuarioService {

    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(Long id);
    Usuario createUsuario(Usuario usuario);
    Usuario updateUsuario(Long id, Usuario usuario);
    void deleteUsuario(Long id);
    boolean authenticateUsuario(String correoUsuario, String password_usuario);

}