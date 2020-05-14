package com.proyecto.mycommunity.models.entity.wait;

public class Estacionamientos {

    private int idEstacionamiento;
    private String numero;
    private float m2;
    private String estado;

    public Estacionamientos() {
    }

    public Estacionamientos(int idEstacionamiento, String numero, float m2, String estado) {
        this.idEstacionamiento = idEstacionamiento;
        this.numero = numero;
        this.m2 = m2;
        this.estado = estado;
    }

    public int getIdEstacionamiento() {
        return idEstacionamiento;
    }

    public void setIdEstacionamiento(int idEstacionamiento) {
        this.idEstacionamiento = idEstacionamiento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public float getM2() {
        return m2;
    }

    public void setM2(float m2) {
        this.m2 = m2;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
