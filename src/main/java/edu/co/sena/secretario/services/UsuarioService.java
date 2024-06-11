package edu.co.sena.secretario.services;

import edu.co.sena.secretario.contracts.UsuarioDto;
import edu.co.sena.secretario.entities.UsuarioEntity;
import edu.co.sena.secretario.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void register(UsuarioDto dto) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setNombreUsuario(dto.getNombreUsuario());
        entity.setContrasena(dto.getContrasena());
        usuarioRepository.save(entity);
    }

    public boolean login(UsuarioDto dto) {
        UsuarioEntity usuario = usuarioRepository.findByNombreUsuarioAndContrasena(dto.getNombreUsuario(), dto.getContrasena());
        return usuario != null;
    }
}