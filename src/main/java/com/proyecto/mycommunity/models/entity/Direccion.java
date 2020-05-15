package com.proyecto.mycommunity.models.entity;

public class Direccion {

    private int idDireccion;
    private String calle;
    private int nCalle;
    private Comuna idComuna;

    public Direccion() {
    }

    public Direccion(int idDireccion, String calle, int nCalle, Comuna idComuna) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.nCalle = nCalle;
        this.idComuna = idComuna;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getnCalle() {
        return nCalle;
    }

    public void setnCalle(int nCalle) {
        this.nCalle = nCalle;
    }

    public Comuna getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(Comuna idComuna) {
        this.idComuna = idComuna;
    }
}
