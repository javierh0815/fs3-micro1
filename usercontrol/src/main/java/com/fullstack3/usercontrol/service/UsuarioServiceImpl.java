package com.fullstack3.usercontrol.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.fullstack3.usercontrol.exception.UsuarioAlreadyExistsException;
import com.fullstack3.usercontrol.model.Usuario;
import com.fullstack3.usercontrol.repository.UsuarioRepository;
import com.fullstack3.usercontrol.repository.UsuarioBorradoRepository;
import com.fullstack3.usercontrol.exception.UsuarioNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import com.fullstack3.usercontrol.model.UsuarioBorrado;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioBorradoRepository usuarioBorradoRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioBorradoRepository usuarioBorradoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioBorradoRepository = usuarioBorradoRepository;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        boolean existeCorreo = usuarioRepository.existsByCorreoUsuario(usuario.getCorreoUsuario());
        if (existeCorreo) {
            throw new UsuarioAlreadyExistsException(usuario.getCorreo_usuario());
        }
        usuario.setFlag_activo(true);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setCod_usuario(usuario.getCod_usuario());
            usuarioExistente.setNombre_usuario(usuario.getNombre_usuario());
            usuarioExistente.setCorreo_usuario(usuario.getCorreo_usuario());
            usuarioExistente.setPassword_usuario(usuario.getPassword_usuario());
            usuarioExistente.setFlag_activo(usuario.getFlag_activo());
            usuarioExistente.setFecha_modificacion(usuario.getFecha_modificacion());
            return usuarioRepository.save(usuarioExistente);
        }
        return null;
    }

    @Override
    @Transactional 
    public void deleteUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        UsuarioBorrado usuarioBorrado = new UsuarioBorrado();
        usuarioBorrado.setCod_usuario(usuario.getCod_usuario());
        usuarioBorrado.setNombre_usuario(usuario.getNombre_usuario());
        usuarioBorrado.setCorreo_usuario(usuario.getCorreo_usuario());
        usuarioBorrado.setPassword_usuario(usuario.getPassword_usuario());
        usuarioBorrado.setFlag_activo(false); 
        usuarioBorrado.setFecha_borrado(LocalDateTime.now());
        usuarioBorradoRepository.save(usuarioBorrado);
        usuarioRepository.delete(usuario);
    }

    @Override
    public boolean authenticateUsuario(String correoUsuario, String passwordUsuario) {

        Usuario usuario = usuarioRepository.findByCorreoUsuario(correoUsuario).orElse(null);

        if (usuario != null) {
            boolean passwordMatch = usuario.getPassword_usuario().equals(passwordUsuario);
            boolean isActive = Boolean.TRUE.equals(usuario.getFlag_activo());
            
            return passwordMatch && isActive;
        }
        
        return false;
    }



}