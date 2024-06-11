package edu.co.sena.secretario.repositories;

import edu.co.sena.secretario.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    UsuarioEntity findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);
}