package edu.co.sena.secretario.contracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private String nombreUsuario;
    private String contrasena;
}