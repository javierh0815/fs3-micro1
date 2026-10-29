package com.fullstack3.usercontrol.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String correo_usuario) {
        super("Usuario no encontrado: " + correo_usuario);
    }
    
}
