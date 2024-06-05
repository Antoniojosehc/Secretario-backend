package edu.co.sena.secretario.entities;

import java.io.Serializable;
import java.util.Objects;

public class InformeMensualId implements Serializable {

    private int anio;
    private String mes;
    private Long publicador;

    // Default constructor
    public InformeMensualId() {}

    // Parameterized constructor
    public InformeMensualId(int anio, String mes, Long publicador) {
        this.anio = anio;
        this.mes = mes;
        this.publicador = publicador;
    }

    // Getters and setters

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Long getPublicador() {
        return publicador;
    }

    public void setPublicador(Long publicador) {
        this.publicador = publicador;
    }

    // Equals and hashCode based on anio, mes, and publicador

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InformeMensualId that = (InformeMensualId) o;
        return anio == that.anio && Objects.equals(mes, that.mes) && Objects.equals(publicador, that.publicador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anio, mes, publicador);
    }
}