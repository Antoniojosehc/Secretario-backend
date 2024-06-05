package edu.co.sena.secretario.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "informe_mensual")
@IdClass(InformeMensualId.class)
public class InformeMensualEntity {

    @Id
    @Column(name = "anio")
    private int anio;

    @Id
    @Column(name = "mes")
    private String mes;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_publicador")
    private PublicadorEntity publicador;

    @Column(name = "publicaciones")
    private int publicaciones;

    @Column(name = "videos")
    private int videos;

    @Column(name = "horas")
    private int horas;
}