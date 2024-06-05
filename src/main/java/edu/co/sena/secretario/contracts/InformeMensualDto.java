package edu.co.sena.secretario.contracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InformeMensualDto {

    private int anio;
    private String mes;
    private int publicaciones;
    private int videos;
    private int horas;
    private Long idPublicador;
}