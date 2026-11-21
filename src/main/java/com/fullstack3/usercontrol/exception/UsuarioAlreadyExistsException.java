package com.fullstack3.usercontrol.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioAlreadyExistsException extends RuntimeException {
    public UsuarioAlreadyExistsException(String correo) {
        super("Ya existe un usuario registrado con el correo: " + correo);
    }
}