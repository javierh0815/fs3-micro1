package com.fullstack3.usercontrol.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.fullstack3.usercontrol.model.Usuario;
import com.fullstack3.usercontrol.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
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
        boolean existeCorreo = usuarioRepository.existsByEmail(usuario.getCorreo_usuario());
        
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
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
    
}
