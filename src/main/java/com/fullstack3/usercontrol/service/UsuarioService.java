package com.fullstack3.usercontrol.service;

import com.fullstack3.usercontrol.dto.LoginRequestDTO;
import com.fullstack3.usercontrol.dto.UsuarioRequestDTO;
import com.fullstack3.usercontrol.dto.UsuarioResponseDTO;
import java.util.List;

public interface UsuarioService {

    List<UsuarioResponseDTO> getAllUsuarios();
    UsuarioResponseDTO getUsuarioById(Long id);
    UsuarioResponseDTO createUsuario(UsuarioRequestDTO request);
    UsuarioResponseDTO updateUsuario(Long id, UsuarioRequestDTO request);
    void deleteUsuario(Long id);
    UsuarioResponseDTO authenticateUsuario(LoginRequestDTO credenciales);

}