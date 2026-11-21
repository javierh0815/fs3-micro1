package com.fullstack3.usercontrol.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.fullstack3.usercontrol.dto.LoginRequestDTO;
import com.fullstack3.usercontrol.dto.UsuarioRequestDTO;
import com.fullstack3.usercontrol.dto.UsuarioResponseDTO;
import com.fullstack3.usercontrol.exception.UsuarioAlreadyExistsException;
import com.fullstack3.usercontrol.exception.UsuarioNotFoundException;
import com.fullstack3.usercontrol.model.Usuario;
import com.fullstack3.usercontrol.model.UsuarioBorrado;
import com.fullstack3.usercontrol.repository.UsuarioBorradoRepository;
import com.fullstack3.usercontrol.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioBorradoRepository usuarioBorradoRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioBorradoRepository usuarioBorradoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioBorradoRepository = usuarioBorradoRepository;
    }

    @Override
    public List<UsuarioResponseDTO> getAllUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO getUsuarioById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
        return mapToResponseDTO(usuario);
    }

    @Override
    public UsuarioResponseDTO createUsuario(UsuarioRequestDTO request) {
        boolean existeCorreo = usuarioRepository.existsByCorreoUsuario(request.getCorreoUsuario());
        if (existeCorreo) {
            throw new UsuarioAlreadyExistsException(request.getCorreoUsuario());
        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre_usuario(request.getNombreUsuario());
        nuevoUsuario.setCorreoUsuario(request.getCorreoUsuario());
        nuevoUsuario.setPassword_usuario(request.getPasswordUsuario());
        nuevoUsuario.setRol_usuario(request.getRolUsuario().toUpperCase());
        nuevoUsuario.setFlag_activo(request.getFlagActivo() != null ? request.getFlagActivo() : true);

        Usuario guardado = usuarioRepository.save(nuevoUsuario);
        return mapToResponseDTO(guardado);
    }

    @Override
    public UsuarioResponseDTO updateUsuario(Long id, UsuarioRequestDTO request) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        usuarioExistente.setNombre_usuario(request.getNombreUsuario());
        usuarioExistente.setCorreoUsuario(request.getCorreoUsuario());
        usuarioExistente.setPassword_usuario(request.getPasswordUsuario());
        usuarioExistente.setRol_usuario(request.getRolUsuario().toUpperCase());
        if (request.getFlagActivo() != null) {
            usuarioExistente.setFlag_activo(request.getFlagActivo());
        }

        Usuario actualizado = usuarioRepository.save(usuarioExistente);
        return mapToResponseDTO(actualizado);
    }

    @Override
    @Transactional
    public void deleteUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        UsuarioBorrado usuarioBorrado = new UsuarioBorrado();
        usuarioBorrado.setCod_usuario(usuario.getCod_usuario());
        usuarioBorrado.setNombre_usuario(usuario.getNombre_usuario());
        usuarioBorrado.setCorreoUsuario(usuario.getCorreoUsuario());
        usuarioBorrado.setPassword_usuario(usuario.getPassword_usuario());
        usuarioBorrado.setRol_usuario(usuario.getRol_usuario());
        usuarioBorrado.setFlag_activo(false);
        usuarioBorrado.setFecha_borrado(LocalDateTime.now());

        usuarioBorradoRepository.save(usuarioBorrado);
        usuarioRepository.delete(usuario);
    }

    @Override
    public UsuarioResponseDTO authenticateUsuario(LoginRequestDTO credenciales) {
        Usuario usuario = usuarioRepository.findByCorreoUsuario(credenciales.getCorreoUsuario())
                .orElse(null);

        if (usuario != null) {
            boolean passwordMatch = usuario.getPassword_usuario().equals(credenciales.getPasswordUsuario());
            boolean isActive = Boolean.TRUE.equals(usuario.getFlag_activo());

            if (passwordMatch && isActive) {
                return mapToResponseDTO(usuario);
            }
        }
        return null;
    }

    private UsuarioResponseDTO mapToResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getIdUsuario(),
                usuario.getCod_usuario(),
                usuario.getNombre_usuario(),
                usuario.getCorreoUsuario(),
                usuario.getRol_usuario(),
                usuario.getFlag_activo(),
                usuario.getFecha_creacion()
        );
    }
}