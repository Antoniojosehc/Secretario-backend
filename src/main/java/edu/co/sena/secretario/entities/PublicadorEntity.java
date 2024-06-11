package edu.co.sena.secretario.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Data
@Entity
@Table(name = "publicador")
public class PublicadorEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "born_date")
    private Date bornDate;

    @Column(name = "baptism_date")
    private Date baptismDate;

    @Column(name = "sex")
    private String sex;

    @Column(name = "notes")
    private String notes;
}